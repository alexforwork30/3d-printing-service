package com.printingservice.services;

import com.printingservice.models.UserCredential;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
  @Value("${app.security.jwt.secret}")
  private String secretKey;

  @Value("${app.security.jwt.expiration}")
  private Long expiration;

  public String generateToken(Authentication authentication) {
    UserCredential userCredential = (UserCredential) authentication.getPrincipal();
    return Jwts.builder()
        .setSubject(userCredential.getUsername())
        .setIssuedAt(new java.util.Date())
        .setExpiration(new java.util.Date(System.currentTimeMillis() + expiration))
        .signWith(key())
        .compact();
  }

  public String parseToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      return authHeader.substring(7);
    }
    return null;
  }

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
  }

  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
  }
}
