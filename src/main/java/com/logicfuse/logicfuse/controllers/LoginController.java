package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.CustomerService;
import com.logicfuse.logicfuse.service.JwtService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

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
            String newToken = jwtService.generateToken(customer.getEmail(), customer.getRoles());
            return ResponseEntity.ok(newToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: " + e.getMessage());
        }

    }


    @GetMapping("/ruta-protegida")
    public ResponseEntity<String> rutaProtegida(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Verifica si el encabezado de autorización está presente y tiene el formato correcto
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                // Extrae el token de JWT del encabezado
                String token = authorizationHeader.substring(7);

                // Valida el token
                if (jwtService.validateToken(token)) {
                    // El token es válido, puedes realizar acciones en la ruta protegida
                    return ResponseEntity.ok("Acceso concedido a la ruta protegida");
                } else {
                    throw new RuntimeException("Token no válido");
                }
            } else {
                throw new RuntimeException("Encabezado de autorización no presente o formato incorrecto");
            }
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para registrar el error.
            return ResponseEntity.status(401).body("Error de autenticación: " + e.getMessage());
        }


    }
    @Autowired
    private CustomerModel customer;


    @GetMapping("/ruta-protegida-admin")
    public ResponseEntity<String> rutaProtegidaAdmin(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Extraer el token del encabezado de autorización
            String token = jwtService.extractToken(authorizationHeader);

            // Obtener el email del token
            String emailFromToken = jwtService.getEmailFromToken(token);

            // Obtener los roles del token
            Set<String> roles = Collections.singleton(jwtService.getRolesFromToken(token));

            // Validar que el usuario tenga el rol "ADMIN"
            if (roles.contains("ADMIN")) {
                // El usuario tiene el rol necesario
                return ResponseEntity.ok("Acceso concedido a la ruta protegida (ADMIN)");
            } else {
                throw new RuntimeException("Usuario no autorizado para acceder a esta ruta");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error de autenticación: " + e.getMessage());
        }
    }


}
