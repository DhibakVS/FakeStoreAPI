package dev.dhibak.ProductService.service;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.client.FakeStoreClient;
import dev.dhibak.ProductService.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private FakeStoreClient fakeStoreClient;

    public ProductDTO[] getAllProductsFromFakeStore(){
        return fakeStoreClient.getAllProduct();
    }
    public ProductDTO getProductById(int id){
        return fakeStoreClient.getProductById(id);
    }
}
