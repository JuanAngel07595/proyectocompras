package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/registeremployee", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<String> register(@RequestBody EmployeeModel employee) {
        try {
            String response = employeeService.register(employee);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }


}

