package com.eight_wiki.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
  @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$", message = "ID는 영어와 숫자로 이루어진 5~15자로 설정해주세요.")
  private String username;

  @NotBlank(message = "Name 입력은 필수입니다.")
  @Column(name="nickName", length = 20, unique = true)
  @Pattern(regexp = "^[a-zA-Z0-9가-힣]{2,12}$",message = "닉네임은 2글자 이상 12글자 미만으로 설정해주세요. 특수문자 불가능. :)")
  private String nickName;

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

  @Enumerated(EnumType.STRING)
  @ColumnDefault("'USER'")
  private Role role;

  @NotBlank
  @Pattern(regexp = "^((19[0-9]\\d{1})|(20((0[0-9])|(1[0-9])|(2[0-2]))))\\-(([1-9])|(1[0-2]))\\-(([1-9])|([1-2][0-9])|30|31)$" )
  private String birth;

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
