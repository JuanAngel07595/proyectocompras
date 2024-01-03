package com.logicfuse.logicfuse.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("El token ha expirado.");
            throw new RuntimeException("El token ha expirado.");
        } catch (UnsupportedJwtException e) {
            System.out.println("Token JWT no soportado.");
            throw new RuntimeException("Token JWT no soportado.");
        } catch (MalformedJwtException | SignatureException | IllegalArgumentException e) {
            System.out.println("Token JWT inválido.");
            throw new RuntimeException("Token JWT inválido.");
        } catch (Exception e) {
            System.out.println("Error al validar el token: " + e.getMessage());
            throw new RuntimeException("Error al validar el token: " + e.getMessage());
        }
    }

}

