package org.ubt.order.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.order.common.dto.PriceCalculationDiscountDTO;
import org.ubt.order.common.enums.OrderStatus;
import org.ubt.order.event.OrderPublisher;
import org.ubt.order.model.Coupon;
import org.ubt.order.model.Order;
import org.ubt.order.model.OrderStatusDTO;
import org.ubt.order.repository.CouponRepository;
import org.ubt.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private CouponRepository couponRepository;
    private OrderPublisher orderPublisher;
    private double calculatedPrice=0.0;

    public OrderServiceImpl(OrderRepository orderRepository, CouponRepository couponRepository, OrderPublisher orderPublisher) {
        this.orderRepository = orderRepository;
        this.couponRepository = couponRepository;
        this.orderPublisher = orderPublisher;
    }

    @SneakyThrows
    @Override
    public void calculateTotalPrice(Order order) {
//        couponRepository.save(new Coupon(1L,"test123",10.0,true));
        double couponDiscountPerc = 0;
//        double totalPrice = order.getTotalPrice();

        try {
            couponDiscountPerc = checkCoupon(order.getCouponCode());
        }catch (Exception e){
            e.printStackTrace();
        }

        orderPublisher.publishMsg(new PriceCalculationDiscountDTO(order.getTotalPrice(),order.getCouponCode(),couponDiscountPerc));
        Thread.sleep(1000);
//        TODO this calculatedPrice should happend in calculator-svc
//        double calculatedPrice = totalPrice - (totalPrice * couponDiscountPerc / 100);


//        order.setTotalPrice(calculatedPrice);

        log.info("==============================");
        log.info("Calculated price {} ",order.getTotalPrice());
        log.info("==============================");
    }

    @SneakyThrows
    @Override
    public void setCalculatedPrice(String finalPrice){
        log.info("This is the price  {} ",finalPrice);
//        double val=Double.valueOf(finalPrice);
//        log.info("This is the ifnal price {} from value ",val);
        //TODO Unparseable number: ""918.0""l
//        NumberFormat nf = NumberFormat.getInstance();
//        double number = nf.parse(finalPrice).doubleValue();
//        this.calculatedPrice=number;
    }


    @Override
    public double checkCoupon(String code) throws Exception {
        Coupon coupon = couponRepository.test(code);
        if(coupon == null || !coupon.is_enabled()){
            throw new Exception("Not available");
        }

        return coupon.getDiscount_percentage();
    }

    @Override
    public int countOrders() {
        return 0;
    }

    @Override
    public List<Order> getCompletedOrder() {
        return orderRepository.getCompletedOrders(OrderStatus.CLOSED.getValue());
    }

    @Override
    public void updateShippingStatus(Order order,OrderStatus orderStatus) {
        log.info("Updating order {} , status to {}",order.getId(),orderStatus.getValue());
        Optional<Order> orderFromDB = orderRepository.findById(order.getId());

        orderFromDB.ifPresent(orderStream -> orderStream.setStatus(orderStatus));

        orderRepository.save(orderFromDB.get());

        log.info("Update order {} , status to {}",order.getId(),orderFromDB.get().getStatus());
    }

    @Override
    public void updateOrder(OrderStatusDTO orderStatusDTO) {
        if(orderStatusDTO.isStatus()){
            orderStatusDTO.getProductCodes().forEach(prdoct-> System.out.println(prdoct));
            log.info(orderStatusDTO.getOrderId());
            //send email and notification
            //make the order as delivery , add that delivery to logistics , and from logistics assign the delivery to a courier
            //save the order in postgresql with businesskey email , status , total price , photo of product , product name.
        }else{
            //here we should get the order_id from stripe controller , and if cancel\
            //get the savedorder to redis with order_id and get the decrement number and increment that shit
            //and delete the order from redis
        }
    }
}
