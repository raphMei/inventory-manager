package com.raphmei.inventorymanager.dto;

import com.raphmei.inventorymanager.entity.MovementType;
import lombok.Data;

@Data
public class StockMovementRequest {
    private Long productId;
    private int quantity;
    private MovementType movementType;
}
