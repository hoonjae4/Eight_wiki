package com.eight_wiki.repository;

import com.eight_wiki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
  boolean existsByNickName(String nickName);
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
  Optional<User> findByUsername(String username);
}
