package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.Product;
import com.raphmei.inventorymanager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if(productRepository.existsByName(product.getName())){
            throw new RuntimeException("Le produit existe deja");
        }
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
       return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit Introuvable"));
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        if(!productRepository.existsById(id)){
            throw new RuntimeException("Il n'y pas de produit avec cette id ");
        }
        productRepository.deleteById(id);
    }
}
