package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.CustomerService;
import com.logicfuse.logicfuse.service.JwtService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomerService customerService;




    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authorizationHeader, @RequestBody Map<String, String> credentials) {
        try {
            String token = jwtService.extractToken(authorizationHeader);
            String emailFromToken = jwtService.getEmailFromToken(token);

            String emailFromBody = credentials.get("email");
            String passwordFromBody = credentials.get("contrasena");

            // Verificar que el correo del token coincida con el correo del cuerpo
            if (!emailFromToken.equals(emailFromBody)) {
                throw new RuntimeException("El correo no coincide");
            }

            // Verificar la contraseña (puedes realizar la autenticación como lo desees)
            if (!customerService.verificarContraseña(passwordFromBody, emailFromToken)) {
                throw new RuntimeException("Contraseña incorrecta");
            }

            // Devolver el token en lugar de un mensaje de éxito
            String newToken = jwtService.generateToken(emailFromToken, Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
            return ResponseEntity.ok(newToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: " + e.getMessage());
        }
    }


    public ResponseEntity<String> rutaProtegida(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String token = jwtService.extractToken(authorizationHeader);
            List<String> roles = jwtService.getRolesFromToken(token);

            if (roles.contains("Admin")) {
                // Acceso permitido para Admin
                return ResponseEntity.ok("Acceso concedido a la ruta protegida para Admin");
            } else if (roles.contains("Usuario Normal")) {
                // Acceso permitido para Usuario Normal
                return ResponseEntity.ok("Acceso concedido a la ruta protegida para Usuario Normal");
            } else {
                throw new RuntimeException("No tienes los roles necesarios para acceder a esta ruta");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error de autenticación: " + e.getMessage());
        }
    }

}
