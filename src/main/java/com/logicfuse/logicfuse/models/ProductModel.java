package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    //Utilizar si se desea cambiar el nombre de el atributo + especificación de el varchar
    private Integer producto_id;

    @Column(unique = true, columnDefinition = "VARCHAR(255)")
    private Integer cod_producto;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nombre_producto;

    private String descripcion;

    private Double precio;

    @Column(columnDefinition = "VARCHAR(100)")
    private String marca;

    @Column(columnDefinition = "VARCHAR(50)")
    private String color;

    private String talla;

    private Integer stock;

    @Column(columnDefinition = "VARCHAR(255)")
    private String imagen_url;

    @ManyToOne
    private CategoryModel categoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productos", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartModel> carritos;



}