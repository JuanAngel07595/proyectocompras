package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtService jwtService;
    public ResponseDTO getAllEmployees (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", employeeRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }


    public String register(EmployeeModel employeeModel) {
        String emailadmin = employeeModel.getEmailadmin();

        // Verificar si ya existe un empleado con el mismo email
        if (employeeRepository.findByEmail(emailadmin) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        // Asignar el email como ID del empleado
        employeeModel.setNumero_documento(employeeModel.getNumero_documento());

        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        employeeModel.setRoles(roles);

        // Resto de la lógica (si es necesario)...

        // Guardar el empleado en la base de datos
        employeeRepository.save(employeeModel);

        // Generar y asignar un token JWT al empleado utilizando el email
        String token = jwtService.generateToken(emailadmin, employeeModel.getRoles());
        employeeModel.setToken(token);

        // Guardar el empleado actualizado con el token
        employeeRepository.save(employeeModel);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }




    public ResponseDTO updateEmployee(EmployeeModel employeeModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", employeeRepository.save(employeeModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteEmployee(String numero_documento) {
        employeeRepository.deleteById(numero_documento);
    }
}
