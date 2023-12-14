package com.foro.api.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

@Component
public class JWTUtils {
  @Value("${jwt.secret.key}")
  private String secretKey;

  @Value("${jwt.time.expiration}")
  private String timeExpiration;

  // !Generamos los tokens de acceso
  public String generateAccesToken(String nombre) {
    return Jwts.builder()
        .setSubject(nombre)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
        .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  // ! validamos si el token ingresado es o no valido
  public boolean isTokenValid(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(getSignatureKey())
          .build()
          .parseClaimsJws(token)
          .getBody();
      return true;
    } catch (Exception e) {
      System.out.println("El token ingresado no es valido".concat(e.getMessage()));
      return false;
    }
  }

  // !obtenemos unicamente el claim del nombre de usuario
  public String getUsernameFromToken(String token) {
    return getClaim(token, Claims::getSubject);
  }

  // !obtenemos los claims que puedan venir
  public <T> T getClaim(String token, Function<Claims, T> claimsFunction) {
    Claims claims = extractAllClaims(token);
    return claimsFunction.apply(claims);
  }

  // !obtenemos todos los datos del token para extraerlos y reusarlos al momento
  // de
  public Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSignatureKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  // !con esto obtenemos la firma del token
  /*
   * private Key getSignatureKey() {
   * byte[] keyBytes = Decoders.BASE64.decode(secretKey);
   * return Keys.hmacShaKeyFor(keyBytes);
   * }
   */

  private Key getSignatureKey() {
    byte[] keyBytes = Base64.getDecoder().decode(secretKey);
    SecretKey llave = Keys.hmacShaKeyFor(keyBytes);
    System.out.println(llave);
    return llave;
  }
}
