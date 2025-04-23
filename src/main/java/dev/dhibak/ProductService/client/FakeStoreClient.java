package dev.dhibak.ProductService.client;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplate restTemplate;

    public ProductDTO[] getAllProduct(){
        String getAllProductURL="https://fakestoreapi.com/products";
        ProductDTO[] response= restTemplate.getForObject(getAllProductURL,ProductDTO[].class);
        return response;
    }

    public ProductDTO getProductById(int id){
        String getProductByIdURL="https://fakestoreapi.com/products/"+id;
        ProductDTO response= restTemplate.getForObject(getProductByIdURL,ProductDTO.class);
        return response;
    }
}
