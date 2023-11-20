package com.logicfuse.logicfuse.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @Column(unique = true)
    private String  numero_documento;

    @Column(columnDefinition = "VARCHAR(2)")
    private String tipo_documento;
    @Column(columnDefinition = "VARCHAR(100)")
    private String nombres;

    @Column(columnDefinition = "VARCHAR(100)")
    private String apellidos;

    @Column(columnDefinition = "VARCHAR(50)")
    private String cargo;

    @Column(columnDefinition = "VARCHAR(20)")
    private String rol;

    private LocalDateTime fecha_registro;

    @Column(columnDefinition = "VARCHAR(100)")
    private String correo_electronico;

    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartModel> carritos;}