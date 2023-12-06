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
    }

    public String login(LoginModel login) {
        try {
            System.out.println("Intento de inicio de sesión para: " + login.getemail());
            LoginModel loginModel = loginRepository.findByEmail(login.getemail());

            if (loginModel != null) {
                System.out.println("Usuario encontrado. Contraseña en LoginModel: " + loginModel.getCustomer().getContrasena());
                System.out.println("Contraseña proporcionada en la solicitud: " + login.getCustomer().getContrasena());

                if (loginModel.getCustomer().getContrasena().equals(login.getCustomer().getContrasena())) {
                    return "Login exitoso";
                } else {
                    throw new RuntimeException("Credenciales incorrec tas");
                }
            } else {
                throw new RuntimeException("Usuario no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para registrar el error.
            throw new RuntimeException("Error en el login: " + e.getMessage());
        }
        }
    }






















