package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;

@RestController
@RequestMapping("/api/auth")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CustomerModel customer) {
        try {
            String response = customerService.register(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel login) {
        try {
            String response = customerService.login(login);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el login: " + e.getMessage());
        }
    }
}

