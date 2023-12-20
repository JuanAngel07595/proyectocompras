package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Ejemplo simplificado en el controlador de registro
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CustomerModel customer) {
        try {
            // Lógica de registro

            return ResponseEntity.ok("Registro exitoso. Ahora inicia sesión para obtener un token JWT.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }


}

