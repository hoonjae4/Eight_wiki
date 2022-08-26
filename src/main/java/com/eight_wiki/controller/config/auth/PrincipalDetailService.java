package com.eight_wiki.controller.config.auth;

import com.eight_wiki.model.User;
import com.eight_wiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PrincipalDetailService implements UserDetailsService {
  @Autowired
  public UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User principal = userRepository.findByUsername(username).orElseThrow(()->{
      return new UsernameNotFoundException("사용자를 찾을수 없음 : " + username);
    });
    return new PrincipalDetail(principal);
  }
}
