// Project 2 - Part 2 : COSC4606 - 001
//Student Name: Manav Patel
//Student ID: 239466460

package com.manav.trentbicycleshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manav.trentbicycleshop.model.Inventory;
import com.manav.trentbicycleshop.model.Return;
import com.manav.trentbicycleshop.repository.InventoryRepository;
import com.manav.trentbicycleshop.repository.ReturnRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ReturnService {

    private final ReturnRepository returnRepository;
    private final InventoryRepository inventoryRepository;

    public ReturnService(ReturnRepository returnRepository,
                         InventoryRepository inventoryRepository) {
        this.returnRepository = returnRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public List<Return> getAllReturns() {
        return returnRepository.findAll();
    }

    public void saveReturn(Return aReturn) {
        aReturn.setReturnDate(LocalDateTime.now());
        Return savedReturn = returnRepository.save(aReturn);

        // Update inventory: add the returned quantity.
        // Since our Return table includes a Product and RefundAmount,
        // you might need to decide how much stock to add based on the return.
        // For simplicity, assume 1-to-1: for each return record, add 1 unit.
        // (In practice, you'd include a 'quantity' field in your Return table.)
        // Here we add a dummy implementation:
        List<Inventory> invList = inventoryRepository.findAllByProduct(savedReturn.getProduct());
        if (!invList.isEmpty()) {
            Inventory inventory = invList.get(0);
            // Here, you might define the returned quantity. For now, we'll assume 1.
            int returnedQuantity = 1;
            int newStock = inventory.getCurrentStock() + returnedQuantity;
            inventory.setCurrentStock(newStock);
            inventory.setLastUpdate(LocalDateTime.now());
            inventoryRepository.save(inventory);
        } else {
            Inventory inventory = new Inventory();
            inventory.setProduct(savedReturn.getProduct());
            // Assume returned quantity is 1
            inventory.setCurrentStock(1);
            inventory.setLastUpdate(LocalDateTime.now());
            inventoryRepository.save(inventory);
        }
    }
}