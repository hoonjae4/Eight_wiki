package com.eight_wiki.controller;

import com.eight_wiki.model.KakaoProfile;
import com.eight_wiki.service.KakaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
  @GetMapping("/auth/kakao/callback")
  @ResponseBody
  public String KakaoCallback(@RequestParam String code, Model model){
    System.out.println("컨트롤러");
    String accessToken = kakaoService.GetAccessToken(code);
    KakaoProfile kakaoProfile = kakaoService.GetKakaoProfile(accessToken);
    return "" + kakaoProfile;
  }
}

