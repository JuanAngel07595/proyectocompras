package com.logicfuse.logicfuse.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer carrito_id;


    private Integer cantidad;

    private Double precio;

    private Double subtotal;

    private LocalDateTime fecha_agregado;

     @ManyToOne
     private EmployeeModel empleados;

     @ManyToOne
     @JoinColumn(name = "producto_id")
     private ProductModel productos;




}

