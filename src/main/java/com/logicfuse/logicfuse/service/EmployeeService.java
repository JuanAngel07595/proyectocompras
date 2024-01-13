package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CustomerModel;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (employeeRepository.findByEmail(employeeModel.getEmail()) != null) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        LoginModel login = new LoginModel(employeeModel.getEmail(), employeeModel);
        employeeModel.setLogin(login);

        employeeModel.getRoles().add("ADMIN");
        employeeRepository.save(employeeModel);

        String token = jwtService.generateToken(employeeModel.getEmail(), employeeModel.getRoles());
        employeeModel.setToken(token);
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
