package com.logicfuse.logicfuse.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;


    public String generateToken(String email, List<String> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("ROLE_USER, ROLE_ADMIN", roles) // Añade los roles al token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }


    public List<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        // Obtén los roles del token
        return claims.get("roles", List.class);
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
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

    public String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        } else {
            throw new RuntimeException("Formato de token inválido");
        }
    }
}




































