package com.raphmei.inventorymanager.repository;

import com.raphmei.inventorymanager.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    boolean existsByEmail(String email);
}
