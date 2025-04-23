package dev.dhibak.ProductService.controller;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import dev.dhibak.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ProductDTO[] getAllProducts(){
        ProductDTO[] response= productService.getAllProductsFromFakeStore();
        return response;
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable("id") int id){
        ProductDTO response=productService.getProductById(id);
        return response;
    }
}
