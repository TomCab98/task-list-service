package com.projects.taskmanager.user.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
public class JwtTokenValidator extends OncePerRequestFilter {
  private final JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(
    @NonNull HttpServletRequest request,
    @NonNull HttpServletResponse response,
    @NonNull FilterChain filterChain
  ) throws ServletException, IOException {

    String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (jwtToken != null) {
      jwtToken = jwtToken.substring(7);

      Jws<Claims> decoded = jwtUtils.validateToken(jwtToken);
      String email = jwtUtils.extractEmail(decoded);
      String stringAuthorities = jwtUtils.getClaim(decoded, "authorities").toString();

      Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);

      SecurityContext context = SecurityContextHolder.getContext();
      Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
      context.setAuthentication(authentication);
      SecurityContextHolder.setContext(context);
    }

    filterChain.doFilter(request, response);
  }
}
