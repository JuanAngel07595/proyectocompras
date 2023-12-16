package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JwtService jwtService;

    // Otros métodos y atributos

    public String login(LoginModel login) {
        try {
            // Tu código de autenticación aquí...

            if (login != null && login.getCustomer().getContrasena().equals(login.getCustomer().getContrasena())) {
                // Autenticación exitosa, generamos el token
                String token = jwtService.generateToken(login.getemail());
                return token;
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Loguear el error o utilizar un logger
            throw new RuntimeException("Error en el login: " + e.getMessage());
        }
    }
}
