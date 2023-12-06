package com.logicfuse.logicfuse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {
        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private LoginRepository loginRepository;

        public String register(CustomerModel customer) {
            if (customerRepository.findByEmail(customer.getEmail()) != null) {
                throw new RuntimeException("El correo electrónico ya está registrado");
            }

            LoginModel login = new LoginModel(customer.getEmail(), customer);
            customer.setLogin(login);

            customerRepository.save(customer);

            return "Registro exitoso";
        }

        // Otros métodos según sea necesario
    }










