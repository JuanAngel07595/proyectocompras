package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
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

    public ResponseDTO getAllCustomers (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", customerRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO saveCustomer(CustomerModel customerModel, LoginModel loginModel) {
        ResponseDTO responseDTO;
        try {
            loginModel.setCustomer(customerModel);
            customerModel.setLogin(loginModel);
            responseDTO = new ResponseDTO(200, "Todo salió bien", customerRepository.save(customerModel));
            return responseDTO;
        } catch (Exception error) {
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO updateCustomer(CustomerModel customerModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", customerRepository.save(customerModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteCustomer(String numero_documento) {
        customerRepository.deleteById(numero_documento);
    }
}


