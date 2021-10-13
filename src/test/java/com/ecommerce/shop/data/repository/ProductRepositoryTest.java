package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepositoryImpl;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(4800);
        product.setCurrency(Currency.NGN);
        product.setDetails("Wetin dey happen, we dey do spring boot class, omo anotations much o, how person go take cram them finish");
        assertThat(product).isNotNull();
        log.info("Product before saving ->{}",product);
        productRepositoryImpl.save(product);
        log.info("Product after saving -> {}", product);
    }
    @Test
    public void whenFindAllProductsIsCalledThenProductListIsReturnedTest(){
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("Product returned from database ->{}", products);
    }
}