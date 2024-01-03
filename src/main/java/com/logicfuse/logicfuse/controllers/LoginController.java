package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.JwtService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody LoginModel login) {
        try {
            String token = loginService.login(login);
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la autenticación: " + e.getMessage());
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

