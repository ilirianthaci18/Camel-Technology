package org.ubt.order.service;

import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.args.GetArgs;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.ubt.order.common.dto.OrderEmailDTO;
import org.ubt.order.common.dto.OrderExpiryTimeRedisDTO;
import org.ubt.order.common.dto.PriceCalculationDiscountDTO;
import org.ubt.order.common.enums.OrderStatus;
import org.ubt.order.common.security.AuthUserService;
import org.ubt.order.event.OrderPublisher;
import org.ubt.order.model.Coupon;
import org.ubt.order.model.Order;
import org.ubt.order.model.OrderStatusDTO;
import org.ubt.order.repository.CouponRepository;
import org.ubt.order.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.ubt.order.common.mappers.OrderMapper.toOrderEmailDTO;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private CouponRepository couponRepository;
    private OrderPublisher orderPublisher;

    private DeliveryService deliveryService;
    private RedisJSON redisJSON;

    private AuthUserService authUserService;

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

        //here we should use sync
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
//        double number = nf.parse(finalPrice).doubleValue();F
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
            OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO=redisJSON.get(orderStatusDTO.getOrderId(),OrderExpiryTimeRedisDTO.class,new GetArgs().path(".").indent("\t").newLine("\n").space(" "));
            log.info(orderStatusDTO.getOrderId());
            orderExpiryTimeRedisDTO.setCustomerEmail(authUserService.getEmail());
            //send email and notification
            //make the order as delivery , add that delivery to logistics , and from logistics assign the delivery to a courier
            //save the order in postgresql with businesskey email , status , total price , photo of product , product name.
            Order order=new Order(orderStatusDTO.getOrderId(),"payment", LocalDateTime.now(),LocalDateTime.now().plusDays(1L)
                    ,orderStatusDTO.getShipTo(),"#shpcmt"+orderStatusDTO.getOrderId(),"test",OrderStatus.NEW,orderExpiryTimeRedisDTO.getTotalPrice(),
                    orderExpiryTimeRedisDTO.getCustomerEmail(),orderExpiryTimeRedisDTO.getProductCode());
            log.info("this is msg ::  {}",order);
            order.setCustomerEmail(authUserService.getEmail());
            String email = authUserService.getEmail();
            orderRepository.save(order);
            log.info("this skipped order save repo ");
//            deliveryService.acceptDelivery(order);
            log.info("this skipped accept delivery");
            orderPublisher.publishOrderToEmail(toOrderEmailDTO(order));
            log.info("this skipped email publish");
            redisJSON.del(orderExpiryTimeRedisDTO.getId(),".");
        }else{
            OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO=redisJSON.get(orderStatusDTO.getOrderId(),OrderExpiryTimeRedisDTO.class,new GetArgs().path(".").indent("\t").newLine("\n").space(" "));
            Long incrementNum=orderExpiryTimeRedisDTO.getQuantity();

            log.info("This is the inc num {}",incrementNum);
            redisJSON.del(orderExpiryTimeRedisDTO.getId(),".");
            //here we should get the order_id from stripe controller , and if cancel\
            //get the savedorder to redis with order_id and get the decrement number and increment that shit
            //and delete the order from redis

            //problem how to know which productCode the quantity ... ?
        }
    }
}
