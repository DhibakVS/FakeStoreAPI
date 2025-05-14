package dev.dhibak.ProductService.service;

import dev.dhibak.ProductService.ProductServiceApplication;
import dev.dhibak.ProductService.client.FakeStoreClient;
import dev.dhibak.ProductService.dto.ProductDTO;
import dev.dhibak.ProductService.dto.ProductProjection;
import dev.dhibak.ProductService.exception.ProductNotFoundException;
import dev.dhibak.ProductService.model.Product;
import dev.dhibak.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Autowired
    private ProductRepository productRepository;

    public Product SaveProduct(Product product){
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }
    public boolean DeleteProduct(int productId){
        productRepository.deleteById(productId);
        return true;
    }
    public Product GetProduct(int productId){
        Optional<Product> product=productRepository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with id "+productId+" not found");
        }else{
            return product.get();
        }
    }
    public List<Product> GetAllProducts(){
        return productRepository.findAll();
    }
    public Product UpdateProduct(int productId,Product newProduct){
        Product savedProduct=GetProduct(productId);
        // newProduct.setId(productId);
        Product updatedProduct=productRepository.save(newProduct);
        return updatedProduct;
    }


    public ProductDTO[] getAllProductsFromFakeStore(){
        return fakeStoreClient.getAllProduct();
    }
    public ProductDTO getProductById(int id){
        return fakeStoreClient.getProductById(id);
    }
    public ProductDTO createProduct(ProductDTO productDTO){
        return fakeStoreClient.createProduct(productDTO);
    }
    public ProductDTO updateProduct(int id,ProductDTO productDTO){
        return fakeStoreClient.updateProduct(id, productDTO);
    }
    public Boolean deleteProduct(int id){
        return fakeStoreClient.deleteProduct(id);
    }
    public ProductProjection getProductProjection(String productName){
        return productRepository.findFirstByName(productName);
    }
}
