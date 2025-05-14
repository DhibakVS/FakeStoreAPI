package dev.dhibak.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private List<Product> products;
}
