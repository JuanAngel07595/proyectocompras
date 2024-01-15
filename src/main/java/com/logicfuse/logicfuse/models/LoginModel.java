package com.logicfuse.logicfuse.models;

import javax.persistence.*;


@Entity
@Table(name = "login")

public class LoginModel {

    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Otros campos y anotaciones según sea necesario

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private CustomerModel customer;


    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private EmployeeModel employee;

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
    public LoginModel(String email, CustomerModel customer) {
        this.email = email;
        this.customer = customer;
    }

    public LoginModel(String email, EmployeeModel employee) {
        this.email = email;
        this.employee = employee;
    }


    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public LoginModel() {
    }
}