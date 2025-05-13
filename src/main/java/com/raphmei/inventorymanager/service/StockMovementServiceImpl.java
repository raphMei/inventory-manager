package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.MovementType;
import com.raphmei.inventorymanager.entity.Product;
import com.raphmei.inventorymanager.entity.StockMovement;
import com.raphmei.inventorymanager.repository.ProductRepository;
import com.raphmei.inventorymanager.repository.StockMovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;

    private final ProductRepository productRepository;

    @Override
    public StockMovement createStockMovement(Long productId, int quantity, MovementType type) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        if (type == MovementType.OUT) {
            if (quantity > product.getQuantity()) {
                throw new RuntimeException("Stock insuffisant");
            }
            product.setQuantity(product.getQuantity() - quantity);
        } else if (type == MovementType.IN) {
            product.setQuantity(product.getQuantity() + quantity);
        }

        productRepository.save(product);

        StockMovement movement = new StockMovement();
        movement.setProduct(product);
        movement.setQuantity(quantity);
        movement.setMovementType(type);

        return stockMovementRepository.save(movement);
    }

    @Override
    public StockMovement getStockMovementById(Long id) {
        return stockMovementRepository.findById(id).orElseThrow(() -> new RuntimeException("Aucun mouvement de stock trouvé"));
    }

    @Override
    public List<StockMovement> getAllStockMovement() {
        return stockMovementRepository.findAll();
    }

    @Override
    public void deleteStockMovementById(Long id) {
        if(!stockMovementRepository.existsById(id)){
            throw new RuntimeException("Aucun mouvement de stock trouvé");
        }
        stockMovementRepository.deleteById(id);
    }
}
