package com.projects.taskmanager.user.infrastructure.security;

import com.projects.taskmanager.core.domain.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

  @Value("${security.jwt.key.private}")
  private String secret;

  @Value("${security.jwt.key.expiration}")
  private long expirationTime;

  @Value("${security.jwt.user.generator}")
  private String userGenerator;

  private SecretKey getSigningKey() {
    return  Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String createToken(Authentication authentication) {
    String username = authentication.getPrincipal().toString();
    String authorities = authentication.getAuthorities()
      .stream()
      .map(GrantedAuthority::getAuthority)
      .collect(Collectors.joining(","));

    return Jwts.builder()
      .subject(username)
      .issuer(userGenerator)
      .issuedAt(new Date())
      .expiration(new Date(System.currentTimeMillis() + expirationTime))
      .claim("authorities", authorities)
      .signWith(getSigningKey())
      .notBefore(new Date(System.currentTimeMillis()))
      .id(UUID.randomUUID().toString()).compact();
  }

  public Jws<Claims> validateToken(String token) {
    try {
      return Jwts.parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token);
    } catch(JwtException e) {
      throw new InvalidTokenException("Invalid token");
    }
  }

  public Claims getAllClaims(Jws<Claims> decoded) {
    return decoded.getPayload();
  }

  public Object getClaim(Jws<Claims> decoded, String claimName) {
    return decoded.getPayload().get(claimName);
  }

  public String extractUsername(Jws<Claims> decoded) {
    return decoded.getPayload().getSubject();
  }
}