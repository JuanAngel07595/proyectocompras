package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.SaleModel;
import com.logicfuse.logicfuse.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public ResponseDTO getAllSales (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", saleRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO saveSale(SaleModel saleModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", saleRepository.save(saleModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO updateSale(SaleModel saleModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", saleRepository.save(saleModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteSale(Integer venta_id) {
        saleRepository.deleteById(venta_id);
    }
}
