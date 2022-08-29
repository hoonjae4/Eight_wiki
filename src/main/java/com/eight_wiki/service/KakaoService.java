package com.eight_wiki.service;

import com.eight_wiki.model.KakaoOauthToken;
import com.eight_wiki.model.KakaoProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoService {

  public String GetAccessToken(String code){
    RestTemplate rt = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

    MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
    params.add("grant_type","authorization_code");
    params.add("client_id","473d50e8b38292f249d4422411e9ac73");
    params.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
    params.add("code",code);

    HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
    ResponseEntity response = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest,
            String.class
    );
    ObjectMapper objectMapper = new ObjectMapper();
    KakaoOauthToken kakaoOauthToken = null;
    try {
      kakaoOauthToken = objectMapper.readValue((String)response.getBody(), KakaoOauthToken.class);
    }catch (JsonMappingException e){
      e.printStackTrace();
    }catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return kakaoOauthToken.getAccess_token();
  }


  public KakaoProfile GetKakaoProfile(String accessToken){
    RestTemplate rt = new RestTemplate();
    HttpHeaders header = new HttpHeaders();
    header.add("Authorization","Bearer "+accessToken);
    header.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

    HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity<>(header);
    ResponseEntity response = rt.exchange(
            "https://kapi.kakao.com/v2/user/me",
            HttpMethod.POST,
            kakaoProfileRequest,
            String.class
    );
    ObjectMapper objectMapper = new ObjectMapper();
    KakaoProfile kakaoProfile = null;
    try {
      kakaoProfile = objectMapper.readValue((String)response.getBody(),KakaoProfile.class);
    }catch (JsonMappingException e){
      e.printStackTrace();
    }catch (JsonProcessingException e){
      e.printStackTrace();
    }
    return kakaoProfile;
  }
}
