package com.raphmei.inventorymanager.service;

import com.raphmei.inventorymanager.entity.Supplier;
import com.raphmei.inventorymanager.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;


    @Override
    public Supplier createSupplier(Supplier supplier) {
        if(supplierRepository.existsByEmail(supplier.getEmail())) {
            throw new RuntimeException("Ce fournisseur existe deja");
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(()->new RuntimeException("Fournisseur non trouvé"));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public void deleteSupplierById(Long id) {
        if(!supplierRepository.existsById(id)) {
            throw new RuntimeException("Fournisseur non trouvé");
        }
        supplierRepository.deleteById(id);
    }
}
