package dev.dhibak.ProductService.controller;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.dto.ProductDTO;
import dev.dhibak.ProductService.model.Product;
import dev.dhibak.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct=productService.SaveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>> GetProducts(){
        List<Product> products=productService.GetAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> GetProduct(@PathVariable("id") int id){
        Product product=productService.GetProduct(id);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> DeleteProduct(@PathVariable("id") int id){
        Boolean isDeleted=productService.DeleteProduct(id);
        return ResponseEntity.ok(isDeleted);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> UpdateProduct(@PathVariable("id") int id,@RequestBody Product newProduct){
        Product updatedProduct=productService.UpdateProduct(id, newProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/product/fake")
    public ProductDTO[] getAllProducts(){
        ProductDTO[] response= productService.getAllProductsFromFakeStore();
        return response;
    }

    @GetMapping("/product/{id}/fake")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") int id){
        if(id<=0){
            throw new IllegalArgumentException("Product Doesn't exist");
//            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        ProductDTO response=productService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/product/fake")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PutMapping("/product/{id}/fake")
    public ProductDTO updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/product/{id}/fake")
    public Boolean deleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleExceptions(Exception ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
