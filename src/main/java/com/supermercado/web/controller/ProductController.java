package com.supermercado.web.controller;

import com.supermercado.domain.Product;
import com.supermercado.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<Product> getProduct(long productId){
        return productService.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(long categoryId){
        return productService.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(long productId){
        return productService.delete(productId);
    }
}
