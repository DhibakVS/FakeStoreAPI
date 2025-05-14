package dev.dhibak.ProductService.repository;

import dev.dhibak.ProductService.dto.ProductProjection;
import dev.dhibak.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByDescription(String description);
    List<Product> findAllByDescriptionIgnoreCase(String description);
    Product findFirstByDescriptionIgnoreCase(String description);
    ProductProjection findFirstByName(String name);
}
