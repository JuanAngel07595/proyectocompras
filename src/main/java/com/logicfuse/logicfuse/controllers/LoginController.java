package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.CustomerService;
import com.logicfuse.logicfuse.service.JwtService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            String passwordFromBody = credentials.get("password");

            // Verificar que el correo del token coincida con el correo del cuerpo
            if (!emailFromToken.equals(emailFromBody)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: El correo no coincide");
            }

            // Logs para depuración
            String storedPassword = customerService.getStoredPassword(emailFromToken);
            System.out.println("Contraseña proporcionada: " + passwordFromBody);
            System.out.println("Contraseña almacenada: " + storedPassword);

            // Verificar la contraseña (puedes realizar la autenticación como lo desees)
            boolean isPasswordCorrect = customerService.verificarContraseña(passwordFromBody, emailFromToken);

            if (!customerService.verificarContraseña(passwordFromBody, emailFromToken)) {
                throw new RuntimeException("Contraseña incorrecta");
            }

            // Devolver el token en lugar de un mensaje de éxito
            String newToken = jwtService.generateToken(emailFromToken);
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
}
