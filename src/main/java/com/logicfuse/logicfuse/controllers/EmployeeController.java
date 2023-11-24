package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        ResponseDTO response = employeeService.getAllEmployees();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveProduct(@Validated @RequestBody EmployeeModel employeeModel) {
        ResponseDTO response = employeeService.saveEmployee(employeeModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
       public ResponseEntity<ResponseDTO> updateProduct(@Validated @PathVariable String numero_documento, @RequestBody EmployeeModel employeeModel) {
    employeeModel.setNumero_documento(numero_documento);
        ResponseDTO response = employeeService.updateEmployee(employeeModel);
      return ResponseEntity.status(response.getCode()).body(response);
   }

    @DeleteMapping("/{id}")
    public void deleteProduct(@Validated @PathVariable String numero_documento) {
        employeeService.deleteEmployee(numero_documento);
    }

}

