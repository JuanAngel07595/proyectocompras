package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmployeeModel employeeModel;

    public String register(CustomerModel customer) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        LoginModel login = new LoginModel(customer.getEmail(), customer);
        customer.setLogin(login);

        customerRepository.save(customer);

        // Determina los roles del usuario al registrarse
        String role = determineRoles(customer.getEmail());

        // Genera el token con los roles
        String token = jwtService.generateToken(customer.getEmail(), Collections.singletonList(role));

        customer.setToken(token);
        customerRepository.save(customer);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }

    // Método para determinar los roles del usuario al registrarse (puedes personalizarlo según tus necesidades)
    private String determineRoles(String email) {
        if (email.toLowerCase().endsWith("admin.com")) {
            return "ROLE_ADMIN";
        } else {
            return "ROLE_USER";
        }
    }

    public boolean verificarContraseña(String contraseñaIngresada, String email) {
        CustomerModel customer = customerRepository.findByEmail(email);
        return customer != null && customer.getContrasena().equals(contraseñaIngresada);
    }
}









































