package com.logicfuse.logicfuse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @Column(unique = true)
    private String numero_documento;

    @Column(columnDefinition = "VARCHAR(2)")
    private String tipo_documento;
    @Column(columnDefinition = "VARCHAR(100)")
    private String nombres;

    @Column(columnDefinition = "VARCHAR(100)")
    private String apellidos;

    @Column(columnDefinition = "VARCHAR(100)")
    private String direccion_entrega;

    private Date fecha_registro;

    @Column(columnDefinition = "VARCHAR(100)")
    private String correo_electronico;

    @Column(columnDefinition = "VARCHAR(255)")
    private String contrasena;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
   @JsonIgnore
   private List<SaleModel> ventas;
}