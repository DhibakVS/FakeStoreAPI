package dev.dhibak.ProductService.controller;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import dev.dhibak.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }
}
