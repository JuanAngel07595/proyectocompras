package com.logicfuse.logicfuse.service;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.HistoricalPriceModel;
import com.logicfuse.logicfuse.models.ProductModel;
import com.logicfuse.logicfuse.repositories.HistoricalPriceRepository;
import com.logicfuse.logicfuse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricalPriceService {

    @Autowired
    private HistoricalPriceRepository historicalPriceRepository;

    public ResponseDTO getAllHistoricalPrice (){
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", historicalPriceRepository.findAll());
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO saveHistoricalPrice(HistoricalPriceModel historicalPriceModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", historicalPriceRepository.save(historicalPriceModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public ResponseDTO updateProduct(HistoricalPriceModel historicalPriceModel) {
        ResponseDTO responseDTO;
        try {
            responseDTO = new ResponseDTO(200, "Todo salio bien", historicalPriceRepository.save(historicalPriceModel));
            return responseDTO;
        }catch (Exception error){
            responseDTO = new ResponseDTO(400, "Hubo un error", error);
            return responseDTO;
        }
    }

    public void deleteHistoricalPrice(Integer producto_id) {
        historicalPriceRepository.deleteById(producto_id);
    }
}