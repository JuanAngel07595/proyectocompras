package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtService jwtService;

    public String register(CustomerModel customer) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        LoginModel login = new LoginModel(customer.getEmail(), customer);
        customer.setLogin(login);

        customerRepository.save(customer);
        customer.getRoles().add("USER");

        String token = jwtService.generateToken(customer.getEmail(), customer.getRoles());
        customer.setToken(token);
        customerRepository.save(customer);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }
    public boolean verificarContraseña(String contraseñaIngresada, String email) {
        CustomerModel customer = customerRepository.findByEmail(email);


        // Verificar si el usuario existe y la contraseña coincide
        return customer != null && customer.getContrasena().equals(contraseñaIngresada);
    }

    // ... Otros métodos y anotaciones ...

    public CustomerModel getCustomerByEmail(String email) {
        try {
            return customerRepository.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el cliente por correo electrónico: " + e.getMessage());
        }
    }
}













































































































































































