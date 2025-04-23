package dev.dhibak.ProductService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Rating {
    private double rate;
    private int count;
}
