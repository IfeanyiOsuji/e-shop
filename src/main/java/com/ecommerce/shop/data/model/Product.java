package com.ecommerce.shop.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name = "product_name")
    private String name;
    @Column // you don't need this if you are not specifying a special property for the column
    private double price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String details;
    @ElementCollection
    @ToString.Exclude
    private List<String> imageUrl;

    @OneToMany // the first side of the relationship is the class you are currently in and the second side is the variable in the class
    @ToString.Exclude
    private List<FeedBack> feedBacks;
}
