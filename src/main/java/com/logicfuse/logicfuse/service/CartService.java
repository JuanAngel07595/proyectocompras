package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CartModel;
import com.logicfuse.logicfuse.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public ResponseDTO getAllCarts (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", cartRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO saveCart(CartModel cartModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", cartRepository.save(cartModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO updateCart(CartModel cartModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", cartRepository.save(cartModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteCart(Integer carrito_id) {
        cartRepository.deleteById(carrito_id);
    }
}
