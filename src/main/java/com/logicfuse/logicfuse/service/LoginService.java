package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

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
                    // Determina los roles del usuario
                    String role = determineRoles(loginModel.getemail());

                    // Genera el token con los roles
                    return jwtService.generateToken(loginModel.getemail(), Collections.singletonList(role));
                } else {
                    throw new RuntimeException("Credenciales incorrectas");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error en el login: " + e.getMessage());
            }
        }

        // Método para determinar los roles del usuario (puedes personalizarlo según tus necesidades)
        private String determineRoles(String email) {
            if (email.toLowerCase().endsWith("admin.com")) {
                return "ROLE_ADMIN";
            } else {
                return "ROLE_USER";
            }
        }

        public boolean isTokenValid(String token) {
            try {
                return jwtService.validateToken(token);
            } catch (Exception e) {
                return false;
            }
        }
    }
