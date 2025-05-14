package dev.dhibak.ProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private double price;
    private double rating;
    private int quantity;
}
