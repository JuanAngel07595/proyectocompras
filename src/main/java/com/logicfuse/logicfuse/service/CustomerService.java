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

    public String register(CustomerModel customer) {
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        LoginModel login = new LoginModel(customer.getEmail(), customer);
        customer.setLogin(login);

        customerRepository.save(customer);

        String token = jwtService.generateToken(customer.getEmail());
        customer.setToken(token);
        customerRepository.save(customer);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }


    public String getStoredPassword(String email) {
        // Obtener el cliente por correo electrónico desde la base de datos
        CustomerModel customer = customerRepository.findByEmail(email);

        // Verificar si el cliente existe y devolver la contraseña almacenada
        return (customer != null) ? customer.getContrasena() : null;
    }
}











































