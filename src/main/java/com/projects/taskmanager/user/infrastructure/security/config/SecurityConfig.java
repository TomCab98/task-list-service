package com.projects.taskmanager.user.infrastructure.security.config;


import com.projects.taskmanager.user.infrastructure.dtos.PermissionEnum;
import com.projects.taskmanager.user.infrastructure.security.JwtTokenValidator;
import com.projects.taskmanager.user.infrastructure.security.JwtUtils;
import com.projects.taskmanager.user.infrastructure.security.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtUtils jwtUtils) throws Exception {
    return httpSecurity
      .csrf(AbstractHttpConfigurer::disable)
      .httpBasic(Customizer.withDefaults())
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(http -> {
        http.requestMatchers(HttpMethod.GET, "/api/user").hasAuthority(PermissionEnum.READ.name());
        http.requestMatchers(HttpMethod.POST, "/api/user").hasAuthority(PermissionEnum.CREATE.name());
        http.requestMatchers(HttpMethod.PUT, "/api/user").hasAuthority(PermissionEnum.UPDATE.name());

        http.anyRequest().permitAll();
      })
      .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailService);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
