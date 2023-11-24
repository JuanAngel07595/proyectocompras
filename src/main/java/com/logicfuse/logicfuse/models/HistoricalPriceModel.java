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
@Table(name = "historicalprices")
public class HistoricalPriceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer historico_precio_id;

    private Integer cod_producto;

    private double precio;

    private LocalDateTime fecha_modificacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "historicoPrecio", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SaleModel> ventas;
}
