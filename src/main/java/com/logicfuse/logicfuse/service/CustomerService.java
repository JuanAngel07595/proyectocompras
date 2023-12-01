package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.CustomerRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private LoginService loginService;

    public ResponseDTO getAllCustomers() {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", customerRepository.findAll());
            return responseDTO;
        } catch (Exception error) {
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    @Transactional
    public ResponseDTO saveCustomer(CustomerModel customerModel) {
        ResponseDTO responseDTO;
        try {
            customerRepository.save(customerModel);

            // Guardar también el login
            LoginModel loginModel = customerModel.getLogin();
            loginService.saveLogin(loginModel);

            responseDTO = new ResponseDTO(200, "Todo salió bien", customerModel);
            return responseDTO;
        } catch (Exception error) {
            System.err.println("Error al guardar el cliente y su inicio de sesión: " + error.getMessage());
            error.printStackTrace();  // Esto imprimirá el rastreo de la pila en la consola
            responseDTO = new ResponseDTO(400, "Hubo un error al guardar el cliente y su inicio de sesión", error.getMessage());
            return responseDTO;
        }

    }


}