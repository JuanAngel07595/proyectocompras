package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.SaleModel;
import com.logicfuse.logicfuse.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllSales() {
        ResponseDTO response = saleService.getAllSales();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveSale(@Validated @RequestBody SaleModel saleModel) {
        ResponseDTO response = saleService.saveSale(saleModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateSale(@Validated @PathVariable Integer venta_id, @RequestBody SaleModel saleModel) {
        saleModel.setId_venta(venta_id);
        ResponseDTO response = saleService.updateSale(saleModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@Validated @PathVariable Integer venta_id) {
        saleService.deleteSale(venta_id);
    }

}
