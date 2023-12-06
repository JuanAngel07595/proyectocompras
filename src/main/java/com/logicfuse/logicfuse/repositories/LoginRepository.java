package com.logicfuse.logicfuse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.logicfuse.logicfuse.models.LoginModel;
import org.springframework.stereotype.Repository;

@Repository


public interface LoginRepository extends JpaRepository<LoginModel, String> {
    LoginModel findByEmail(String getemail);
}

