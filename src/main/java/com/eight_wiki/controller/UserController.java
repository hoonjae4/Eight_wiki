package com.eight_wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

