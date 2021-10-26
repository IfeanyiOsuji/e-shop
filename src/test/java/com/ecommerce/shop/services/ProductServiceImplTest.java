package com.ecommerce.shop.services;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;
    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

}