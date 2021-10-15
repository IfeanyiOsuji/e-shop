package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productServiceImpl;
    @Autowired
    public ProductController(ProductService productService){
        productServiceImpl = productService;
    }

    @GetMapping("/")
    public List<Product> getAll(){
        return productServiceImpl.findAll();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product){
        log.info("Product request -> {}", product);
        return productServiceImpl.save(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/products")
    public List<Product> saveAll(@RequestBody List<Product> products){
        log.info("Product request -> {}", products);
        return productServiceImpl.saveAll(products);
    }
}
