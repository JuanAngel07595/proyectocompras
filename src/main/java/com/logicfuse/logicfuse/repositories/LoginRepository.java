package com.logicfuse.logicfuse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.logicfuse.logicfuse.models.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, String> {
    LoginModel findByEmail(String getemail);
}

