package com.user.onboarding.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtUtil {

  private static SecretKey key = Jwts.SIG.HS256.key().build();

  private static final long EXPIRATION_TIME = 1000 * 3600;
  
    // Generate JWT
    @SuppressWarnings("deprecation")
  public static String generateToken(String email) {
      return Jwts.builder()
          .subject(email)
          .issuedAt(new Date())
          .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
          .signWith(SignatureAlgorithm.HS256, key)
        .compact();
  }
  

  public static class InvalidJwtException extends RuntimeException {
    public InvalidJwtException(String message) {
      super(message);
    }
  }
}