package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.ProductModel;
import com.logicfuse.logicfuse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseDTO getAllProducts (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", productRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO saveProduct(ProductModel productModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", productRepository.save(productModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO updateProduct(ProductModel productModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", productRepository.save(productModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteProduct(Integer producto_id) {
        productRepository.deleteById(producto_id);
    }
}
