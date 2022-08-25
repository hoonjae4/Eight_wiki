package com.eight_wiki.repository;

import com.eight_wiki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
  boolean existsByNickName(String nickName);
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
