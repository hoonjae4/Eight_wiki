package com.eight_wiki.controller.api;

import com.eight_wiki.controller.dto.ResponseDto;
import com.eight_wiki.controller.dto.UserSaveResponseDto;
import com.eight_wiki.model.Oauth;
import com.eight_wiki.model.User;
import com.eight_wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserApiController {
  @Autowired
  UserService userService;

  @PostMapping("/auth/joinProc")
  public ResponseDto<Integer> join(@RequestBody UserSaveResponseDto userSaveResponseDto){
    System.out.println("UserApiController: save 호출");
    userService.회원가입(userSaveResponseDto);
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }

  @PostMapping("/auth/nickNameCheck")
  public boolean nickNameCheck(@RequestParam("checkNickname") String nickName){
    return userService.duplicateNicknameCheck(nickName);
  }
  @PostMapping("/auth/usernameCheck")
  public boolean usernameCheck(@RequestParam("checkUsername") String username){
    return userService.duplicateUsernameCheck(username);
  }
  @PostMapping("/auth/emailCheck")
  public boolean emailCheck(@RequestParam("checkEmail") String email){
    return userService.duplicateEmailCheck(email);
  }
  @PostMapping("/auth/joinValidation")
  public boolean validation(@RequestBody @Valid UserSaveResponseDto userSaveResponseDto, Errors errors){
    if(errors.hasErrors()){
      System.out.println("회원가입 validation 잘못됨(UserApiController validation호출)");
      return false;
    }
    else{
      return !userService.validation(userSaveResponseDto);
    }
  }
}
