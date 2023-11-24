package com.logicfuse.logicfuse.controllers;

import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.ProductModel;
import com.logicfuse.logicfuse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllProducts() {
        ResponseDTO response = productService.getAllProducts();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveProduct(@Validated @RequestBody ProductModel productModel) {
        ResponseDTO response = productService.saveProduct(productModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateProduct(@Validated @PathVariable Integer producto_id, @RequestBody ProductModel productModel) {
        productModel.setProducto_id(producto_id);
        ResponseDTO response = productService.updateProduct(productModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@Validated @PathVariable Integer producto_id) {
        productService.deleteProduct(producto_id);
    }

}
