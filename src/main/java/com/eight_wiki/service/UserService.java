package com.eight_wiki.service;

import com.eight_wiki.model.User;
import com.eight_wiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  public void 회원가입(User user){
    userRepository.save(user);
  }
}
