package com.raphmei.inventorymanager.controller;

import com.raphmei.inventorymanager.dto.StockMovementRequest;
import com.raphmei.inventorymanager.entity.StockMovement;
import com.raphmei.inventorymanager.service.StockMovementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock_movement")
@AllArgsConstructor
public class StockMovementController {

    private final StockMovementService stockMovementService;

    @PostMapping
    public ResponseEntity<?> createStockMovement(@RequestBody @Valid StockMovementRequest request) {
        return ResponseEntity.ok(
                stockMovementService.createStockMovement(
                        request.getProductId(),
                        request.getQuantity(),
                        request.getMovementType()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<StockMovement>> getAllStockMovement() {
        return ResponseEntity.ok(stockMovementService.getAllStockMovement());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        return ResponseEntity.ok(stockMovementService.getStockMovementById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockMovementById(@PathVariable Long id) {
        stockMovementService.deleteStockMovementById(id);
        return ResponseEntity.noContent().build();
    }
}
