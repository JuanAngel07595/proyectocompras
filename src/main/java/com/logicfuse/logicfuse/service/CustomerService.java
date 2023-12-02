package com.logicfuse.logicfuse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;

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

        // Guardar el cliente y su login en la base de datos
        customerRepository.save(customer);

        return "Registro exitoso";
    }

    public String login(LoginModel login) {
        // Realizar lógica de autenticación aquí
        // Puedes utilizar Spring Security u otras técnicas según tus necesidades

        // Ejemplo simple: Verificar si el correo electrónico y la contraseña coinciden
        CustomerModel customer = customerRepository.findByEmail(login.getemail());

        if (customer != null && customer.getContrasena().equals(login.getCustomer().getContrasena())) {
            return "Login exitoso";
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}

