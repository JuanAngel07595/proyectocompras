package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginModel login) {
        try {
            String token = loginService.login(login);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la autenticación: " + e.getMessage());
        }
    }
}
