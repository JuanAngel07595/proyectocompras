package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.EmployeeRepository;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtService jwtService;

    public String register(EmployeeModel employee) {
        if (employeeRepository.findByEmail(employee.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        LoginModel login = new LoginModel(employee.getEmail(), employee);
        employee.setLogin(login);

        employeeRepository.save(employee);
        employee.getRoles().add("ADMIN");

        String token = jwtService.generateToken(employee.getEmail(), employee.getRoles());
        employee.setToken(token);
        employeeRepository.save(employee);

        return "Registro exitoso. Token JWT almacenado en la base de datos.";
    }
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

    public boolean verificarContraseña(String contraseñaIngresada, String email) {
        EmployeeModel employee = employeeRepository.findByEmail(email);


        // Verificar si el usuario existe y la contraseña coincide
        return employee != null && employee.getContrasena().equals(contraseñaIngresada);
    }

    public ResponseDTO saveEmployee(EmployeeModel employeeModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", employeeRepository.save(employeeModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
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

