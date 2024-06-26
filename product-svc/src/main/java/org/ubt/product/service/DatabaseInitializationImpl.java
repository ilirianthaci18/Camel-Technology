package org.ubt.product.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ubt.product.model.Brand;
import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;
import org.ubt.product.model.WareHouse;
import org.ubt.product.repository.BrandRepository;
import org.ubt.product.repository.WareHouseRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DatabaseInitializationImpl implements DatabaseInitialization {

    private InventoryService inventoryService;
    private BrandRepository brandRepository;
    private WareHouseRepository wareHouseRepository;

    @PostConstruct
    @Override
    public void initDB() {
        //initializeInventory();
    }

    private void initializeBrands() {
        Brand brand = new Brand().builder()
                .name("Apple")
                .logo("logo.png")
                .category("Phone")
                .favorite(true)
                .build();

        Brand brand2 = new Brand().builder()
                .name("Samsung")
                .logo("logo2.png")
                .category("Phone")
                .favorite(true)
                .build();

        Brand brand3 = new Brand().builder()
                .name("MI")
                .logo("logo3.png")
                .category("Phone")
                .favorite(true)
                .build();

        Brand brand4 = new Brand().builder()
                .name("RedDragon")
                .logo("logo4.png")
                .category("Laptop")
                .favorite(true)
                .build();


        List<Brand> brands=new ArrayList<>();
        brands.add(brand);
        brands.add(brand2);
        brands.add(brand3);
//        Iterable<Brand> brandss=brandRepository.saveAll(brands);
    }

    private void initializeInventory() {
        Inventory inventory = new Inventory().builder()
                .stockQuantity(1)
                .triggerQuantity(1)
                .stockType("Preferred Stock")
                .inventoryDescription("The total cost of all component parts currently in stock that have not yet been used in work-in-process or finished goods production")
                .inventoryType("Raw Material Inventory")
                .build();

        Inventory inventory2 = new Inventory().builder()
                .stockQuantity(2)
                .triggerQuantity(4)
                .stockType("Growth Stock")
                .inventoryDescription("Production and supply-chain management term describing partially finished goods awaiting completion")
                .inventoryType("Work in Progress Inventory")
                .build();

        Inventory inventory3 = new Inventory().builder()
                .stockQuantity(3)
                .triggerQuantity(5)
                .stockType("Value Stock")
                .inventoryDescription("The total stock available for customers to purchase that can be fulfilled")
                .inventoryType("Finished Good Inventory")
                .build();

//        inventoryService.saveInventory(inventory);
//        inventoryService.saveInventory(inventory2);
//        inventoryService.saveInventory(inventory3);
    }

    private void initializeWareHouse() {
        WareHouse wareHouse = new WareHouse().builder()
                .RFID(true)
                .wareHouseLocation("Europe")
                .wareHouseSerialNumberPalett("STL0011")
                .build();

        WareHouse wareHouse2 = new WareHouse().builder()
                .RFID(false)
                .wareHouseLocation("Asia")
                .wareHouseSerialNumberPalett("STL0022")
                .build();

        WareHouse wareHouse3 = new WareHouse().builder()
                .RFID(true)
                .wareHouseLocation("Africa")
                .wareHouseSerialNumberPalett("STL0033")
                .build();

        WareHouse wareHouse4 = new WareHouse().builder()
                .RFID(false)
                .wareHouseLocation("America")
                .wareHouseSerialNumberPalett("STL0044")
                .build();

        List<WareHouse> wareHouses=new ArrayList<>();
        wareHouses.add(wareHouse);
        wareHouses.add(wareHouse2);
        wareHouses.add(wareHouse3);
        wareHouses.add(wareHouse4);

//        Iterable<WareHouse> wareHouses1=wareHouseRepository.saveAll(wareHouses);
    }
}
