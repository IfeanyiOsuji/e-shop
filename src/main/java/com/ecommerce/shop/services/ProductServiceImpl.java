package com.ecommerce.shop.services;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import com.ecommerce.shop.web.exceptions.ProductDoesNotExistException;
import com.ecommerce.shop.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        if(productDto == null){
            throw new NullPointerException("Product Dto cannot be null");
        }
        Optional<Product>result = productRepository.findById(id);
        if(result.isPresent()){
           Product product = result.get();
           productMapper.mapDtoProduct(productDto, product);
           return productRepository.save(product);
        }
        else {
            throw new ProductDoesNotExistException("Product with id "+id+" does not exist");
        }
    }
}
