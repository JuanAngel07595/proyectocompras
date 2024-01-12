package com.logicfuse.logicfuse.controllers;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.service.CustomerService;
import com.logicfuse.logicfuse.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;


import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JwtService jwtService;
    
    
    @PostMapping("/register")
    public String register(CustomerModel customer, boolean isAdmin) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        // Otros procesos de registro...

        customer.setRol(isAdmin ? "ROLE_ADMIN" : "ROLE_USER"); // Establecer el rol

        String token = jwtService.generateToken(customer.getEmail(), Collections.singletonList(customer.getRol()));

        customer.setToken(token);
        customerService.register(customer);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }

}
