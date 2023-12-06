package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public String login(LoginModel login) {
        try {
            System.out.println("Intento de inicio de sesión para: " + login.getemail());
            LoginModel loginModel = loginRepository.findByEmail(login.getemail());

            if (loginModel != null) {
                System.out.println("Usuario encontrado. Contraseña en LoginModel: " + loginModel.getCustomer().getContrasena());
                System.out.println("Contraseña proporcionada en la solicitud: " + login.getCustomer().getContrasena());

                if (loginModel.getCustomer().getContrasena().equals(login.getCustomer().getContrasena())) {
                    return "Login exitoso";
                } else {
                    throw new RuntimeException("Credenciales incorrec tas");
                }
            } else {
                throw new RuntimeException("Usuario no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace(); // O utiliza un logger para registrar el error.
            throw new RuntimeException("Error en el login: " + e.getMessage());
        }
    }
}
