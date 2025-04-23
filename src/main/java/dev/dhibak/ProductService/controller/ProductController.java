package dev.dhibak.ProductService.controller;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import dev.dhibak.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") int id){
        if(id<=0){
            throw new IllegalArgumentException("Product Doesn't exist");
//            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        ProductDTO response=productService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleExceptions(Exception ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
