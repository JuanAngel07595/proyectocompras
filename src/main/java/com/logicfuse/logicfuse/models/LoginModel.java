package com.logicfuse.logicfuse.models;

import javax.persistence.*;


@Entity
@Table(name = "login")

public class LoginModel {

    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Otros campos y anotaciones según sea necesario


    @OneToOne(mappedBy = "customerl", cascade = CascadeType.ALL)
    private CustomerModel customerlogin;



    @OneToOne(mappedBy = "employeel", cascade = CascadeType.ALL)
    private EmployeeModel employeelogin;

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public CustomerModel getCustomer() {
        return customerlogin ;
    }

    public void setCustomer(CustomerModel customer) {
        this.customerlogin = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeModel getEmployee() {
        return employeelogin;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employeelogin = employee;
    }

    public LoginModel(String email, CustomerModel customer) {
        this.email = email;
        this.customerlogin = customer;
    }

    public LoginModel(String email, EmployeeModel employee) {
        this.email = email;
        this.employeelogin = employee;
    }

    public LoginModel(EmployeeModel employee) {
        this.employeelogin = employee;
    }

    public LoginModel() {
    }
}