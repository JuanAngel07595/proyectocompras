package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LoginRepository loginRepository;

    public String login(LoginModel login) {
        try {
            LoginModel loginModel = loginRepository.findByEmail(login.getemail());

            if (loginModel != null && loginModel.getCustomer().getContrasena().equals(login.getCustomer().getContrasena())) {
                String token = jwtService.generateToken(loginModel.getemail());
                return token;
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error en el login: " + e.getMessage());
        }
    }
}
