package com.eight_wiki.controller.dto;

import com.eight_wiki.model.Gender;
import com.eight_wiki.model.Oauth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveResponseDto {
  @NotBlank(message = "ID 입력은 필수입니다.")
  @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$", message = "ID는 영어와 숫자로 이루어진 5~15자로 설정해주세요.")
  private String username;

  @NotBlank(message = "Name 입력은 필수입니다.")
  @Pattern(regexp = "^[a-zA-Z0-9가-힣]{2,12}$",message = "닉네임은 2글자 이상 12글자 미만으로 설정해주세요. 특수문자 불가능. :)")
  private String nickName;

  @NotBlank(message="Email 입력은 필수입니다.")
  private String email;

  @NotBlank(message = "Password 입력은 필수입니다.")
  @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
          message = "비밀번호는 영문자와, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자로 설정해주세요.")
  private String password;

  private String introduce;

  @NotBlank
  @Pattern(regexp = "^((19[0-9]\\d{1})|(20((0[0-9])|(1[0-9])|(2[0-2]))))\\-(([1-9])|(1[0-2]))\\-(([1-9])|([1-2][0-9])|30|31)$" )
  private String birth;

  @Enumerated(EnumType.STRING)
  private Oauth oauth; //kakao,google

  @Enumerated(EnumType.STRING)
  private Gender gender;
}
