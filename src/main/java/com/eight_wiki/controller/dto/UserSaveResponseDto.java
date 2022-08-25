package com.eight_wiki.controller.dto;

import com.eight_wiki.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveResponseDto {
  @NotBlank(message = "ID 입력은 필수입니다.")
  private String username;

  @NotBlank(message = "Name 입력은 필수입니다.")
  private String nickname;

  @NotBlank(message="Email 입력은 필수입니다.")
  private String email;

  @NotBlank(message = "Password 입력은 필수입니다.")
  @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
          message = "비밀번호는 영문자와, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")

  private String password;

  private String introduce;

  @NotBlank(message="생년월일 입력은 필수입니다.")
  private int birthYear;
  @NotBlank(message="생년월일 입력은 필수입니다.")
  private int birthMonth;
  @NotBlank(message="생년월일 입력은 필수입니다.")
  private int birthDay;

  @Enumerated(EnumType.STRING)
  @NotBlank(message="성별 입력은 필수입니다.")
  private Gender gender;
}
