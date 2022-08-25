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

  public boolean duplicateNicknameCheck(String nickName){
    return userRepository.existsByNickName(nickName);
  }
  public boolean duplicateUsernameCheck(String username) { return userRepository.existsByUsername(username); }
  public boolean duplicateEmailCheck(String email) { return userRepository.existsByEmail(email); }
}
