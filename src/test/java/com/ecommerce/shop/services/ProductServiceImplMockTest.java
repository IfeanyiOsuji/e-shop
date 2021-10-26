package com.ecommerce.shop.services;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
public class ProductServiceImplMockTest {
    @Autowired
    ProductService productServiceImpl;

    @Autowired
    ProductRepository productRepository;
    @Test
    void updateProductTest(){
        Product product = productRepository.findById(110L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Luxury chair");
        // call the service update method
        ProductDto productDto = new ProductDto();
        productDto.setName("Mexican chair");
        product = productServiceImpl.updateProduct(110L, productDto);
        assertThat(product.getName()).isEqualTo(productDto.getName());

    }

}
