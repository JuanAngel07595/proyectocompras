package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.service.CustomerService;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {


    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel login) {
        try {
            String response = loginService.login(login);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para registrar el error.
            return ResponseEntity.badRequest().body("Error en el login: " + e.getMessage());
        }
    }
}
