package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.EmployeeModel;
import com.logicfuse.logicfuse.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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
