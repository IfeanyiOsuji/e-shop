package com.ecommerce.shop.data.dto;

import com.ecommerce.shop.data.model.Currency;
import lombok.Data;

// when we have mapstructcore and lombork, we need import a plugin that allows them work together
@Data
public class ProductDto {
    private String name;
    private Double price;
    private Currency currency;
    private String details;
}
