package com.eight_wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
  @GetMapping("/auth/join")
  public String join(){
    return "user/joinForm";
  }

  @GetMapping("/auth/login")
  public String login(){
    return "user/loginForm";
  }
}

