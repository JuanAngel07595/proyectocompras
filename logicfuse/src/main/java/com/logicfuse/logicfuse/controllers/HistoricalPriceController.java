package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.HistoricalPriceModel;
import com.logicfuse.logicfuse.models.ProductModel;
import com.logicfuse.logicfuse.service.HistoricalPriceService;
import com.logicfuse.logicfuse.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/historicalprice")
public class HistoricalPriceController {

    @Autowired
    private HistoricalPriceService historicalPriceService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllHistoricalPrice() {
        ResponseDTO response = historicalPriceService.getAllHistoricalPrice();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveProduct(@Validated @RequestBody HistoricalPriceModel historicalPriceModel) {
        ResponseDTO response = historicalPriceService.saveHistoricalPrice(historicalPriceModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    //@PutMapping("/{id}")
    //public ResponseEntity<ResponseDTO> updateHistoricalPrice(@Validated @PathVariable Integer historico_precio_id, @RequestBody HistoricalPriceModel historicalPriceModel) {
    //    historicalPriceModel.setProducto_id(historico_precio_id);
    //   ResponseDTO response = historicalPriceService.updateProduct(historicalPriceModel);
    //   return ResponseEntity.status(response.getCode()).body(response);
    //}

    @DeleteMapping("/{id}")
    public void deleteHistoricalPrice(@Validated @PathVariable Integer historico_precio_id) {
        historicalPriceService.deleteHistoricalPrice(historico_precio_id);
    }

}
