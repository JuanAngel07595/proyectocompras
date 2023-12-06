package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
public class LoginController {



        @Autowired
        private LoginService loginService;

        @PostMapping
        public ResponseEntity<String> login(@RequestBody LoginModel login) {
            try {
                String response = loginService.login(login);
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error en el login: " + e.getMessage());
            }
        }
    }

