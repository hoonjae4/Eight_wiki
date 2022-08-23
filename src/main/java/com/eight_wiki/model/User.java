package com.eight_wiki.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotBlank(message = "ID 입력은 필수입니다.")
  @Column(name="username", length = 100, unique = true)
  private String username;

  @NotBlank(message = "Name 입력은 필수입니다.")
  @Column(name="name", length = 20, unique = true)
  private String name;

  @NotBlank(message="Email 입력은 필수입니다.")
  @Column(name="email", length = 100, unique = true)
  private String email;

  @NotBlank(message = "Password 입력은 필수입니다.")
  @Column(name = "password", length = 255)
  private String password;

  @Column(name = "introduce", nullable = true, length = 1000)
  private String introduce;

  @Enumerated(EnumType.STRING)
  private Oauth oauth; //kakao,google

  @NotBlank
  @Column(name="birthYear")
  private int birthYear;
  @NotBlank
  @Column(name="birthMonth")
  private int birthMonth;
  @NotBlank(message="생년월일 입력은 필수입니다.")
  @Column(name="birthDay", nullable = false)
  private int birthDay;

  @Column(name = "createTime",updatable = false)
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @PrePersist
  public void before() {
    LocalDateTime now = LocalDateTime.now();
    this.createTime = now;
    this.updateTime = now;
  }
  @PreUpdate
  public void always(){
    this.updateTime = LocalDateTime.now();
  }
}
