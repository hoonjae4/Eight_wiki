package com.eight_wiki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class KakaoProfile {

  public Long id;
  public String connected_at;
  public Properties properties;
  public Kakao_account kakao_account;
  @Data
  static public class Kakao_account {
    public Boolean profile_nickname_needs_agreement;
    public Boolean profile_image_needs_agreement;
    public Profile profile;
    public Boolean has_email;
    public Boolean email_needs_agreement;
    public Boolean is_email_valid;
    public Boolean is_email_verified;
    public String email;
    public Boolean has_birthday;
    public Boolean birthday_needs_agreement;
    public String birthday;
    public String birthday_type;
    public Boolean has_gender;
    public Boolean gender_needs_agreement;
    public String gender;

  }
  @Data
  static public class Profile {

    public String nickname;
    public String thumbnail_image_url;
    public String profile_image_url;
    public Boolean is_default_image;

  }
  @Data
  static public class Properties {

    public String nickname;
    public String profile_image;
    public String thumbnail_image;

  }
}