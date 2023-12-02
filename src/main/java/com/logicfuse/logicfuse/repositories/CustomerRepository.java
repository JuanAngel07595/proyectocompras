package com.logicfuse.logicfuse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.logicfuse.logicfuse.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    CustomerModel findbycorreo_electronico(String correo_electronico);
}
