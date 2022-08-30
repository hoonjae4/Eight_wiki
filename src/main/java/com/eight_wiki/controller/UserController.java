package com.eight_wiki.controller;

import com.eight_wiki.model.KakaoProfile;
import com.eight_wiki.model.Oauth;
import com.eight_wiki.model.User;
import com.eight_wiki.repository.UserRepository;
import com.eight_wiki.service.KakaoService;
import com.eight_wiki.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
  @GetMapping("/auth/join")
  public String join(){
    return "user/joinForm";
  }

  @GetMapping("/auth/login")
  public String login(@RequestParam(value = "error",required = false)String error,
                      @RequestParam(value = "exception", required = false)String exception,
                      @RequestParam(value = "errorType",required = false)String errorType,
                      Model model) {
    model.addAttribute("error",error);
    model.addAttribute("exception",exception);
    model.addAttribute("errorType",errorType);
    return "user/loginForm";
  }
  @Autowired
  KakaoService kakaoService;
  @Autowired
  UserRepository userRepository;
  @Autowired
  AuthenticationManager authenticationManager;
  @Value("${hoon.key}")
  private String kakaoKey;
  @GetMapping("/auth/kakao/callback")
  public String KakaoCallback(@RequestParam String code, RedirectAttributes model){
    System.out.println("컨트롤러");
    String accessToken = kakaoService.GetAccessToken(code);
    KakaoProfile kakaoProfile = kakaoService.GetKakaoProfile(accessToken);
    User kakaoUser = userRepository.findByEmail(kakaoProfile.getKakao_account().getEmail()).orElse(null);
    String password = kakaoKey + kakaoProfile.getId();
    if(kakaoUser == null){
      kakaoUser = new User();
      kakaoUser.setOauth(Oauth.KAKAO);kakaoUser.setEmail(kakaoProfile.getKakao_account().getEmail());kakaoUser.setPassword(password);
      model.addFlashAttribute("kakaoUser",kakaoUser);
      return "redirect:/auth/join";
    }else{
      if(kakaoUser.getOauth()==Oauth.KAKAO){
        //세션등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(),password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
      }
      else{
        //basic으로 로그인
        model.addFlashAttribute("kakaoUser",kakaoUser);
        model.addFlashAttribute("kakaoError",true);
        model.addFlashAttribute("kakaoException","이미 사용중인 Email이라 카카오 로그인이 불가능 합니다. 기존 로그인을 이욯해주세요.");
        return "redirect:/auth/login";
      }
    }
  }
}

