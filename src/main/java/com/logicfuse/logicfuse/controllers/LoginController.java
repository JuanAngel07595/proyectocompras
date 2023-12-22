package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.JwtService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginModel login) {
        try {
            String token = loginService.login(login);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la autenticación: " + e.getMessage());
        }


    }
    @GetMapping("/resource")
    public String getResource(@RequestHeader("Authorization") String authorizationHeader) {
        // Extraer el token de la cabecera Authorization
        String token = authorizationHeader.substring("Bearer ".length());

        // Verificar la validez del token
        if (jwtService.validateToken(token)) {
            // Lógica para manejar el recurso protegido
            return "Recurso protegido accesible";
        } else {
            return "Token inválido o expirado";
        }

    }}
