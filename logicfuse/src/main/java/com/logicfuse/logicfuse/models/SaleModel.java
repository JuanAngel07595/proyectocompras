package com.logicfuse.logicfuse.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id_venta;

    private Integer cantidad;

    private Double subtotal;

    private LocalDateTime fecha_venta;

    @Column(columnDefinition = "VARCHAR(255)")
    private String direccion_entrega;

    @ManyToOne
    private CustomerModel cliente;

    @ManyToOne
    @JoinColumn(name = "historico_precio_id")
    private HistoricalPriceModel historicoPrecio;
}
