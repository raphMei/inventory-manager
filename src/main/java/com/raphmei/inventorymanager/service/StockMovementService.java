package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.MovementType;
import com.raphmei.inventorymanager.entity.StockMovement;

import java.util.List;

public interface StockMovementService {

    StockMovement createStockMovement(Long productId, int quantity, MovementType type);
    StockMovement getStockMovementById(Long id);
    List<StockMovement> getAllStockMovement();
    void deleteStockMovementById(Long id);
}
