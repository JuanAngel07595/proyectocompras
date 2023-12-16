package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtService jwtService;

    public String register(CustomerModel customer, String jwtToken) {
        try {
            // Validar el token JWT
            if (!jwtService.validateToken(jwtToken)) {
                throw new RuntimeException("Token JWT no válido");
            }

            // Verificar si el correo electrónico ya está registrado
            if (customerRepository.findByEmail(customer.getEmail()) != null) {
                throw new RuntimeException("El correo electrónico ya está registrado");
            }

            // Crear instancia de LoginModel y establecer la relación bidireccional
            LoginModel login = new LoginModel(customer.getEmail(), customer);
            customer.setLogin(login);

            // Guardar el cliente y su login en la base de datos
            customerRepository.save(customer);

            return "Registro exitoso";
        } catch (Exception e) {
            e.printStackTrace(); // Loguear el error o utilizar un logger
            throw new RuntimeException("Error en el registro: " + e.getMessage());
        }
    }

    // Otros métodos y atributos
}











































