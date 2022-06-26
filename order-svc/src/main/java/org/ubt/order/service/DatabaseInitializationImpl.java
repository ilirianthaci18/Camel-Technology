package org.ubt.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ubt.order.common.enums.CurrencyStatus;
import org.ubt.order.common.enums.DeliveryStatus;
import org.ubt.order.common.enums.DeliveryType;
import org.ubt.order.common.enums.OrderStatus;
import org.ubt.order.model.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor
@Service
public class DatabaseInitializationImpl implements DatabaseInitialization{

    @PostConstruct
    @Override
    public void initDB() {

    }

    private void initializeDelivery(){
        Delivery delivery = new Delivery().builder()
                .name("Delivery")
                .type(DeliveryType.NORMAL)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.NORMAL)
                .address("Prishtine,Kosovo")
                .paid(false)
                .needsToPay(50.40)
                .build();

        Delivery delivery2 = new Delivery().builder()
                .name("Delivery2")
                .type(DeliveryType.URGENT)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.URGENT)
                .address("Prizren,Kosovo")
                .paid(true)
                .needsToPay(00.00)
                .build();

        Delivery delivery3 = new Delivery().builder()
                .name("Delivery3")
                .type(DeliveryType.FAST)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.FAST)
                .address("Viena,Austria")
                .paid(true)
                .needsToPay(00.00)
                .build();

        Delivery delivery4 = new Delivery().builder()
                .name("Delivery4")
                .type(DeliveryType.NORMAL)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.NORMAL)
                .address("Paris,France")
                .paid(false)
                .needsToPay(220.00)
                .build();

        Delivery delivery5 = new Delivery().builder()
                .name("Delivery5")
                .type(DeliveryType.FAST)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.FAST)
                .address("Peje,Kosovo")
                .paid(false)
                .needsToPay(900.80)
                .build();

        Delivery delivery6 = new Delivery().builder()
                .name("Delivery6")
                .type(DeliveryType.URGENT)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.URGENT)
                .address("Gjilan,Kosovo")
                .paid(true)
                .needsToPay(00.00)
                .build();

        Delivery delivery7 = new Delivery().builder()
                .name("Delivery7")
                .type(DeliveryType.FAST)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.FAST)
                .address("Gjakova,Kosovo")
                .paid(false)
                .needsToPay(325.00)
                .build();

        Delivery delivery8 = new Delivery().builder()
                .name("Delivery8")
                .type(DeliveryType.NORMAL)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.NORMAL)
                .address("Mitrovica,Kosovo")
                .paid(false)
                .needsToPay(876.80)
                .build();

        Delivery delivery9 = new Delivery().builder()
                .name("Delivery9")
                .type(DeliveryType.FAST)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.FAST)
                .address("Ferizaj,Kosovo")
                .paid(true)
                .needsToPay(00.00)
                .build();

        Delivery delivery10 = new Delivery().builder()
                .name("Delivery9")
                .type(DeliveryType.URGENT)
                .date(LocalDateTime.now())
                .status(DeliveryStatus.URGENT)
                .address("Prishtine,Kosovo")
                .paid(false)
                .needsToPay(999.99)
                .build();
    }

    private void initializeLogistics(){
        Logistics logistics =  new Logistics().builder()
                .name("GXO Logistics")
                .drivers(2)
                .paid(LocalDateTime.now())
                .dateAccepted(LocalDateTime.now())
                .fee(5.4)
                .deliveredBy("Detjon Qoqaj")
                .acceptedBy("Client1")
                .build();

        Logistics logistics2 =  new Logistics().builder()
                .name("Americold")
                .drivers(7)
                .paid(LocalDateTime.now())
                .dateAccepted(LocalDateTime.now())
                .fee(2.4)
                .deliveredBy("Ilirian Thaqi")
                .acceptedBy("Client2")
                .build();

        Logistics logistics3 =  new Logistics().builder()
                .name("DHL")
                .drivers(4)
                .paid(LocalDateTime.now())
                .dateAccepted(LocalDateTime.now())
                .fee(1.4)
                .deliveredBy("Uranik Hodaj")
                .acceptedBy("Client3")
                .build();

        Logistics logistics4 =  new Logistics().builder()
                .name("GEODIS North America (OHL)")
                .drivers(2)
                .paid(LocalDateTime.now())
                .dateAccepted(LocalDateTime.now())
                .fee(5.4)
                .deliveredBy("Arber Kadriu")
                .acceptedBy("Client4")
                .build();

    }

    private void initializeOrder(){
        Order order = new Order().builder()
                .orderType("Regular")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T12:45:30"))
                .ship_to("Client1")
                .shippingId("SH100ID")
                .status(OrderStatus.NEW)
                .totalPrice(250.00)
                .build();

        Order order2 = new Order().builder()
                .orderType("Regular")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T15:45:30"))
                .ship_to("Client2")
                .shippingId("SH101ID")
                .status(OrderStatus.HOLD)
                .totalPrice(300.00)
                .build();

        Order order3 = new Order().builder()
                .orderType("Urgent")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-07-03T10:45:30"))
                .ship_to("Client3")
                .shippingId("SH102ID")
                .status(OrderStatus.SHIPPED)
                .totalPrice(980.00)
                .build();

        Order order4 = new Order().builder()
                .orderType("Fast")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-05-03T18:30:30"))
                .ship_to("Client4")
                .shippingId("SH103ID")
                .status(OrderStatus.NEW)
                .totalPrice(325.40)
                .build();

        Order order5 = new Order().builder()
                .orderType("Urgent")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T12:45:30"))
                .ship_to("Client5")
                .shippingId("SH104ID")
                .status(OrderStatus.DELIVERED)
                .totalPrice(152.00)
                .build();

        Order order6 = new Order().builder()
                .orderType("Regular")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T19:45:30"))
                .ship_to("Client6")
                .shippingId("SH105ID")
                .status(OrderStatus.CLOSED)
                .totalPrice(783.40)
                .build();

        Order order7 = new Order().builder()
                .orderType("Fast")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T12:45:30"))
                .ship_to("Client7")
                .shippingId("SH106ID")
                .status(OrderStatus.NEW)
                .totalPrice(12.50)
                .build();

        Order order8 = new Order().builder()
                .orderType("Fast")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-03-03T16:45:30"))
                .ship_to("Client8")
                .shippingId("SH107ID")
                .status(OrderStatus.HOLD)
                .totalPrice(278.00)
                .build();

        Order order9 = new Order().builder()
                .orderType("Fast")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-04-03T11:25:15"))
                .ship_to("Client9")
                .shippingId("SH108ID")
                .status(OrderStatus.SHIPPED)
                .totalPrice(637.40)
                .build();

        Order order10 = new Order().builder()
                .orderType("Urgent")
                .ordered(LocalDateTime.now())
                .shipped(LocalDateTime.parse("2022-06-03T12:45:30"))
                .ship_to("Client10")
                .shippingId("SH109ID")
                .status(OrderStatus.NEW)
                .totalPrice(467.20)
                .build();
    }

    private void initializePrice(){

        Price price = new Price().builder()
                .price(150.90)
                .discountPercentage(20)
                .priceStartDate("20-06-2022")
                .priceEndDate("25-06-2022")
                .currency("EUR")
                .currencyRate(1.0)
                .exchangeRateWithEuro(1.0)
                .taxPercentage(18.0)
                .status(CurrencyStatus.ACTIVE)
                .build();

        Price price2 = new Price().builder()
                .price(320.90)
                .discountPercentage(15)
                .priceStartDate("21-06-2022")
                .priceEndDate("26-06-2022")
                .currency("USD")
                .currencyRate(0.87)
                .exchangeRateWithEuro(0.87)
                .taxPercentage(12.0)
                .status(CurrencyStatus.BLOCKED)
                .build();

        Price price3 = new Price().builder()
                .price(890.90)
                .discountPercentage(20)
                .priceStartDate("22-06-2022")
                .priceEndDate("27-06-2022")
                .currency("CAD")
                .currencyRate(0.73)
                .exchangeRateWithEuro(0.73)
                .taxPercentage(10.0)
                .status(CurrencyStatus.BLOCKED)
                .build();

        Price price4 = new Price().builder()
                .price(304.90)
                .discountPercentage(30)
                .priceStartDate("23-06-2022")
                .priceEndDate("28-06-2022")
                .currency("CAD")
                .currencyRate(0.73)
                .exchangeRateWithEuro(0.73)
                .taxPercentage(8.0)
                .status(CurrencyStatus.ACTIVE)
                .build();

        Price price5 = new Price().builder()
                .price(490.90)
                .discountPercentage(40)
                .priceStartDate("24-06-2022")
                .priceEndDate("29-06-2022")
                .currency("EUR")
                .currencyRate(1.0)
                .exchangeRateWithEuro(1.0)
                .taxPercentage(10.0)
                .status(CurrencyStatus.BLOCKED)
                .build();

        Price price6 = new Price().builder()
                .price(309.90)
                .discountPercentage(20)
                .priceStartDate("25-06-2022")
                .priceEndDate("30-06-2022")
                .currency("RBL")
                .currencyRate(0.017)
                .exchangeRateWithEuro(0.017)
                .taxPercentage(4.0)
                .status(CurrencyStatus.DISABLED)
                .build();

        Price price7 = new Price().builder()
                .price(700.99)
                .discountPercentage(35)
                .priceStartDate("25-06-2022")
                .priceEndDate("01-07-2022")
                .currency("ALL")
                .currencyRate(120.1)
                .exchangeRateWithEuro(120.1)
                .taxPercentage(10.0)
                .status(CurrencyStatus.ACTIVE)
                .build();

        Price price8 = new Price().builder()
                .price(12.90)
                .discountPercentage(0)
                .priceStartDate("26-06-2022")
                .priceEndDate("02-07-2022")
                .currency("MRK")
                .currencyRate(1.93)
                .exchangeRateWithEuro(1.93)
                .taxPercentage(10.0)
                .status(CurrencyStatus.DISABLED)
                .build();

        Price price9 = new Price().builder()
                .price(580.30)
                .discountPercentage(50)
                .priceStartDate("28-06-2022")
                .priceEndDate("03-07-2022")
                .currency("EUR")
                .currencyRate(0.00)
                .exchangeRateWithEuro(0.00)
                .taxPercentage(1.0)
                .status(CurrencyStatus.ACTIVE)
                .build();

        Price price10 = new Price().builder()
                .price(103.60)
                .discountPercentage(15)
                .priceStartDate("28-06-2022")
                .priceEndDate("04-06-2022")
                .currency("CAD")
                .currencyRate(0.73)
                .exchangeRateWithEuro(0.73)
                .taxPercentage(9.0)
                .status(CurrencyStatus.ACTIVE)
                .build();
    }

}
