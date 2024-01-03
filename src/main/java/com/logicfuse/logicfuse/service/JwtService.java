package com.logicfuse.logicfuse.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Key secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);

    public boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();

            // Obtener la fecha de expiración del token
            long expirationTimeMillis = claims.getExpiration().getTime();

            // Obtener la fecha actual en milisegundos
            long currentTimeMillis = System.currentTimeMillis();

            // Verificar si el token ha expirado
            return currentTimeMillis > expirationTimeMillis;
        } catch (Exception e) {
            // Manejar la excepción si ocurre algún problema durante la verificación del token
            e.printStackTrace();
            return true; // Tratamos como si el token está expirado para seguridad adicional
        }
    }




    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
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
        } catch (Exception e) {
            return false;
        }
    }
    }

