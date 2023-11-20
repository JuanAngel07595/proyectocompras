package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllProducts() {
        ResponseDTO response = customerService.getAllCustomers();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveCustomer(@Validated @RequestBody CustomerModel customerModel) {
        ResponseDTO response = customerService.saveCustomer(customerModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateCustomer(@Validated @PathVariable String numero_documento, @RequestBody CustomerModel customerModel) {
        customerModel.setNumero_documento(numero_documento);
        ResponseDTO response = customerService.updateCustomer(customerModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@Validated @PathVariable String numero_documento) {
        customerService.deleteCustomer(numero_documento);
    }

}



