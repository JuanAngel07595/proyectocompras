package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    public ResponseDTO saveLogin(LoginModel loginModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salió bien", loginRepository.save(loginModel));
            return responseDTO;
        } catch (Exception error) {
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    // Puedes agregar más métodos según tus necesidades
}

