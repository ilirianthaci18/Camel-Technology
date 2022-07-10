package org.ubt.profile.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ubt.profile.model.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

@AllArgsConstructor
@Service
public class DatabaseInitializationImpl implements DatabaseInitialization {



    @PostConstruct
    @Override
    public void initDB() {

    }

    private void initializeCustomer(){
        Customer customer=new Customer().builder()
//                .id(124855)
                .postalCode("10000")
                .billindAddress("Prishtine,Lakrishte")
                .shippingAddress("Prishtine,Lakrishte")
                .city("Prishtine")
                .state("Kosovo")
                .build();

        Customer customer2=new Customer().builder()
//                .id(124856)
                .postalCode("20000")
                .billindAddress("Prizren,Arbane")
                .shippingAddress("Prizren,Arbane")
                .city("Prizren")
                .state("Kosovo")
                .build();

        Customer customer3=new Customer().builder()
//                .id(124857)
                .postalCode("20000")
                .billindAddress("Prizren,Ortakoll")
                .shippingAddress("Prizren,Ortakoll")
                .city("Prizren")
                .state("Kosovo")
                .build();

        Customer customer4=new Customer().builder()
//                .id(124856)
                .postalCode("1010")
                .billindAddress("Inner Stadt,Viene")
                .shippingAddress("Inner Stadt,Viene")
                .city("Viene")
                .state("Austria")
                .build();
    }
    private void initializeHistoricalOrder(){
        HistoricalOrder historicalOrder = new HistoricalOrder().builder()
                .details("Total orders: 5 , Delivered: 5, In Progress: 0")
                .orderType("Regular")
                .build();

        HistoricalOrder historicalOrder2 = new HistoricalOrder().builder()
                .details("Total orders: 2 , Delivered: 1, In Progress: 1")
                .orderType("Regular")
                .build();

        HistoricalOrder historicalOrder3 = new HistoricalOrder().builder()
                .details("Total orders: 10 , Delivered: 8, In Progress: 2")
                .orderType("Fast")
                .build();

    }

    private void initializeShipmentTracking(){

        ShipmentTracking shipmentTracking = new ShipmentTracking().builder()
                .shipmentDate("05-06-2022")
                .shipmentType("Land")
                .shipmentDescription("Shipped via land transport")
                .shipmentStatus("In progress")
                .shipmentBy("Train")
                .shipmentRegionId("EU2005SH")
                .shipmentFeedback("No issues in the way back")
                .build();

        ShipmentTracking shipmentTracking2 = new ShipmentTracking().builder()
                .shipmentDate("06-06-2022")
                .shipmentType("Air")
                .shipmentDescription("Shipped via air transport")
                .shipmentStatus("Delivered")
                .shipmentBy("Plane")
                .shipmentRegionId("AM2006SH")
                .shipmentFeedback("No issues in the way back")
                .build();

        ShipmentTracking shipmentTracking3 = new ShipmentTracking().builder()
                .shipmentDate("07-06-2022")
                .shipmentType("Sea")
                .shipmentDescription("Shipped via sea transport")
                .shipmentStatus("Delivered")
                .shipmentBy("Ship")
                .shipmentRegionId("AF2008SH")
                .shipmentFeedback("No issues in the way back")
                .build();
    }

    private void initializeShoppingCart(){

        ShoppingCart shoppingCart = new ShoppingCart().builder()
                .created(new Date())
                .quantity(2)
                .dateAdded(new Date())
                .build();

        ShoppingCart shoppingCart2 = new ShoppingCart().builder()
                .created(new Date())
                .quantity(4)
                .dateAdded(new Date())
                .build();

        ShoppingCart shoppingCart3 = new ShoppingCart().builder()
                .created(new Date())
                .quantity(5)
                .dateAdded(new Date())
                .build();

        ShoppingCart shoppingCart4 = new ShoppingCart().builder()
                .created(new Date())
                .quantity(6)
                .dateAdded(new Date())
                .build();
    }

    private void initializeUser(){

        User user = new User().builder()
                .name("Detjon")
                .surname("Qoqaj")
                .address("Prishtine,Lakrishte")
                .phoneNumber("+38349593574")
                .email("dq48223@ubt-uni.net")
                .password("joni1234")
                .role("Admin")
                .deleted(false)
                .build();

        User user1 = new User().builder()
                .name("Ilirian")
                .surname("Thaqi")
                .address("Prishtine,Bregu i Diellit")
                .phoneNumber("+38349112552")
                .email("il48224@ubt-uni.net")
                .password("ilirian1234")
                .role("User")
                .deleted(false)
                .build();

        User user3 = new User().builder()
                .name("Uranik")
                .surname("Hodaj")
                .address("Prishtine,Lakrishte")
                .phoneNumber("+38349445878")
                .email("uh48222@ubt-uni.net")
                .password("niki1234")
                .role("User")
                .deleted(false)
                .build();

        User user4 = new User().builder()
                .name("Arber")
                .surname("Kadriu")
                .address("Prishtine,Rruga B")
                .phoneNumber("+38349777777")
                .email("ak48226@ubt-uni.net")
                .password("arber1234")
                .role("User")
                .deleted(false)
                .build();

        User user5 = new User().builder()
                .name("Medina")
                .surname("Shamolli")
                .address("Prishtine,Dardani")
                .phoneNumber("+38349523368")
                .email("ms48228@ubt-uni.net")
                .password("medina1234")
                .role("User")
                .deleted(false)
                .build();


    }

    private void initializeWishList(){
        WishList wishList = new WishList().builder()
                .details(Collections.singletonList("Wishlist content: 5 Products"))
                .userId("ilirianthaqi@live.com")
//                .valueOfWishList(350.55)
                .build();

        WishList wishList2 = new WishList().builder()
                .details(Collections.singletonList("Wishlist content: 8 Products"))
                .userId("ilirianthaqi@live.com")
//                .valueOfWishList(950.55)
                .build();

        WishList wishList3 = new WishList().builder()
                .details(Collections.singletonList("Wishlist content: 6 Products"))
                .userId("ilirianthaqi@live.com")
//                .valueOfWishList(220.40)
                .build();

        WishList wishList4 = new WishList().builder()
                .details(Collections.singletonList("Wishlist content: 9 Products"))
                .userId("ilirianthaqi@live.com")
//                .valueOfWishList(900.40)
                .build();

        WishList wishList5 = new WishList().builder()
                .details(Collections.singletonList("Wishlist content: 9 Products"))
                .userId("ilirianthaqi@live.com")
//                .valueOfWishList(200.50)
                .build();

    }
}
