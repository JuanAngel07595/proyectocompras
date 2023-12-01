package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.LoginModel;
import com.logicfuse.logicfuse.models.SaleModel;
import com.logicfuse.logicfuse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping(name = "/login")


@RestController
@RequestMapping(name = "/login")
public class LoginController {

@Autowired
    LoginService loginService;


    @PostMapping
    public ResponseEntity<ResponseDTO> saveSale(@Validated @RequestBody LoginModel loginModel) {
        ResponseDTO response = loginService.saveLogin(loginModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

}
