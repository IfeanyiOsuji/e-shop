package com.ecommerce.shop.data.model;

import lombok.Getter;

@Getter
public enum Currency {

    NGN("Naira"),
    USD("Dollar"),
    SRC(""),
    GBP("British Pounds"),
    FRC(""),
    GHC("");

    private String name;
    Currency(String s){
        this.name = name;

    }

}

