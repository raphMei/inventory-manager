package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> findAllProduct();
    void deleteProductById(Long id);
}
