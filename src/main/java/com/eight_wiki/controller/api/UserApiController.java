package com.eight_wiki.controller.api;

import com.eight_wiki.controller.dto.ResponseDto;
import com.eight_wiki.model.Oauth;
import com.eight_wiki.model.User;
import com.eight_wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
  @Autowired
  UserService userService;

  @PostMapping("/join")
  public ResponseDto<Integer> save(@RequestBody User user){
    System.out.println("UserApiController: save 호출");
    user.setOauth(Oauth.BASIC);
    userService.회원가입(user);
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
  }
}
