package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    void deleteSupplierById(Long id);

}
