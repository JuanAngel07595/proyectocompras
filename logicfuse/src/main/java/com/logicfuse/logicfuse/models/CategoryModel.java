package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer categoria_id;

    private String nombre;

    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "categoria")
    @JsonIgnore
    private List<ProductModel> productos;

}
