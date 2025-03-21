package com.projects.taskmanager.user.infrastructure.security;

import com.projects.taskmanager.core.domain.exceptions.BadCredentialsException;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.user.infrastructure.dtos.AuthRequestDto;
import com.projects.taskmanager.user.infrastructure.dtos.AuthResponseDto;
import com.projects.taskmanager.user.infrastructure.repositories.UserRepository;
import com.projects.taskmanager.user.infrastructure.repositories.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) {

    UserEntity userEntity = repository.findUserEntityByUsername(username)
      .orElseThrow(() -> new NotFoundException("user not found"));

    List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();

    userEntity.getRoles()
      .forEach(role -> grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

    userEntity.getRoles()
      .stream()
      .flatMap(role -> role.getPermissionList().stream())
      .forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getPermission().name())));

    return new User(
      userEntity.getUsername(),
      userEntity.getPassword(),
      userEntity.isEnabled(),
      userEntity.isAccountNoExpired(),
      userEntity.isCredentialsNoExpired(),
      userEntity.isAccountNoLocked(),
      grantedAuthorityList
    );
  }

  public AuthResponseDto login(AuthRequestDto request) {
    String username = request.username();
    String password = request.password();

    Authentication authentication = this.authenticate(username, password);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String accessToken = jwtUtils.createToken(authentication);

    return new AuthResponseDto(
      username,
      "User login successfully",
      accessToken,
      true
    );
  }

  public Authentication authenticate(String username, String password) {
    UserDetails userDetails = this.loadUserByUsername(username);

    if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException("invalid username or password");
    }

    return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
  }

  public String encodePassword(String password) {
    return this.passwordEncoder.encode(password);
  }
}
