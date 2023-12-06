package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class LoginService {


        @Autowired
        private CustomerRepository customerRepository;

        public String login(LoginModel login) {
            try {
                CustomerModel customer = customerRepository.findByEmail(login.getemail());

                if (customer != null && customer.getContrasena().equals(login.getCustomer().getContrasena())) {
                    return "Login exitoso";
                } else {
                    throw new RuntimeException("Credenciales incorrectas");
                }
            } catch (EntityNotFoundException e) {
                throw new RuntimeException("Usuario no encontrado");
            } catch (RuntimeException e) {
                throw new RuntimeException("Error en el login: " + e.getMessage());
            }
        }

        // Otros métodos según sea necesario
    }


