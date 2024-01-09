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

    @Autowired
    private CustomerService customerService;


    public String login(LoginModel login) {
        try {
            LoginModel loginModel = loginRepository.findByEmail(login.getemail());

            if (loginModel != null && customerService.verificarContraseña(login.getCustomer().getContrasena(), loginModel.getemail())) {
                return jwtService.generateToken(loginModel.getemail());
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error en el login: " + e.getMessage());
        }
    }



    public boolean isTokenValid(String token) {
        try {
            // Intenta validar el token
            return jwtService.validateToken(token);
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para registrar el error.
            return false;
        }
    }
}