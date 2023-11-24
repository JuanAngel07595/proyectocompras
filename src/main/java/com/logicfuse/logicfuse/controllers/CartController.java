package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CartModel;
import com.logicfuse.logicfuse.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCarts() {
        ResponseDTO response = cartService.getAllCarts();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveCart(@Validated @RequestBody CartModel cartModel) {
        ResponseDTO response = cartService.saveCart(cartModel);
        return ResponseEntity.status(response.getCode()).body(response);
    }

  //  @PutMapping("/{id}")
    //public ResponseEntity<ResponseDTO> updateCart(@Validated @PathVariable Integer producto_id, @RequestBody CartModel cartModel) {
  //  cartModel.setProducto_id(carrito_id);
    //    ResponseDTO response = cartService.updateCart(cartModel);
    //  return ResponseEntity.status(response.getCode()).body(response);
    //}

    @DeleteMapping("/{id}")
    public void deleteCart(@Validated @PathVariable Integer carrito_id) {
        cartService.deleteCart(carrito_id);
    }

}

