package com.eight_wiki.service;

import com.eight_wiki.controller.dto.UserSaveResponseDto;
import com.eight_wiki.model.Oauth;
import com.eight_wiki.model.User;
import com.eight_wiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  public void 회원가입(UserSaveResponseDto userSaveResponseDto){
    User user = User.builder()
            .oauth(Oauth.BASIC)
            .nickName(userSaveResponseDto.getNickName())
            .username(userSaveResponseDto.getUsername())
            .password(userSaveResponseDto.getPassword())
            .email(userSaveResponseDto.getEmail())
            .birth(userSaveResponseDto.getBirth())
            .gender(userSaveResponseDto.getGender())
            .introduce(userSaveResponseDto.getIntroduce())
            .build();
    userRepository.save(user);
  }

  public boolean duplicateNicknameCheck(String nickName){
    return userRepository.existsByNickName(nickName);
  }
  public boolean duplicateUsernameCheck(String username) { return userRepository.existsByUsername(username); }
  public boolean duplicateEmailCheck(String email) { return userRepository.existsByEmail(email); }
  public boolean validation(UserSaveResponseDto userSaveResponseDto){
    //정규식으로 거를수 없는 부분 (Birth)
    String birth = userSaveResponseDto.getBirth();
    int year = Integer.parseInt(birth.split("-")[0]);
    int month = Integer.parseInt(birth.split("-")[1]);
    int day = Integer.parseInt(birth.split("-")[2]);
    if(month == 2){
      if(year % 4 == 0){ //윤년인 경우 30,31은 오류가 있다고 침.
        return day > 29;
      }
      else{
        return day > 28; // 윤년인 아닌 경우 29,30,31은 오류가 있다고 침.
      }
    }
    return false;
  }
}
