package com.eight_wiki.controller.config;

import com.eight_wiki.controller.config.auth.PrincipalDetailService;
import com.eight_wiki.controller.config.handler.CustomAuthFailHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
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
  @Autowired
  private CustomAuthFailHandler customAuthFailHandler;
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
              .failureHandler(customAuthFailHandler)
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

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider bean = new DaoAuthenticationProvider();
    bean.setHideUserNotFoundExceptions(false);
    bean.setPasswordEncoder(encodePWD());
    bean.setUserDetailsService(principalDetailService);
    return bean;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(this.daoAuthenticationProvider());
  }
}
