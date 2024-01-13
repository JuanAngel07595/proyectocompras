package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.CustomerModel;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;
    public String generateToken(String email, Set<String> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    public String generateTokenForAdmin(String email, Set<String> roles) {
        roles.add("ADMIN");  // Agregar el rol "ADMIN" al conjunto de roles

        return Jwts.builder()
                .setSubject(email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }


    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public Set<String> getRolesFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        // Supongamos que los roles están almacenados en el claim "roles"
        List<String> rolesList = claims.get("roles", List.class);

        // Convierte la lista a un conjunto (Set)
        return new HashSet<>(rolesList);
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






















