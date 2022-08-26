package com.eight_wiki.controller.config;

import com.eight_wiki.controller.config.auth.PrincipalDetailService;
import com.eight_wiki.controller.config.handler.CustomAuthFailerHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  private final AuthenticationFailureHandler customFailerHandler;
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests()
              .antMatchers( "/" , "/auth/**" , "/js/**" , "/css/**" , "/image/**")
              .permitAll()
              .anyRequest()
              .authenticated()
            .and()
              .formLogin()
              .loginPage("/auth/login")
              .loginProcessingUrl("/auth/loginProc")
              .defaultSuccessUrl("/")
              .failureHandler(customFailerHandler)
            ;
    http.sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(false);
  }
  @Bean
  public BCryptPasswordEncoder encodePWD(){
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private PrincipalDetailService principalDetailService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
  }
}
