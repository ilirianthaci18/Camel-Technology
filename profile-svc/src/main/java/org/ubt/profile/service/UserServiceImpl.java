package org.ubt.profile.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ubt.profile.exception.NotFoundException;
import org.ubt.profile.model.HistoricalOrder;
import org.ubt.profile.model.Recommendation;
import org.ubt.profile.model.ShipmentTracking;
import org.ubt.profile.model.User;
import org.ubt.profile.repository.HistoricalOrderRepository;
import org.ubt.profile.repository.RecommendationRepository;
import org.ubt.profile.repository.ShipmentTrackingRepository;
import org.ubt.profile.repository.UserRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RecommendationRepository recommendationRepository;
    private ShipmentTrackingRepository shipmentTrackingRepository;
    private HistoricalOrderRepository historicalOrderRepository;

    public List<User> getUsers() throws InterruptedException {
        log.info("Calling service to get Users data...");
        log.debug("This is debug Calling service to get Users data...");
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long id) {
        log.info("Removing user with id " + id);
        userRepository.delete(userRepository.getById(id));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        log.info("Updating user with id " + user.getId());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("User could not be found , id : ", id);
            return new NotFoundException("User with id " + id + "not found");
        });
    }

    @Override
    public void addRecommendationToUser(Long userId, int recommendationId) {
        User user = getUserById(userId);
        Recommendation recommendation = recommendationRepository.findById(recommendationId).orElseThrow(() -> {
            log.error("Recommendation could not be found , id : ", recommendationId);
            return new NotFoundException("Recommendation with id " + recommendationId + "not found");
        });

//        user.addRecommendation(recommendation);

        saveUser(user);

        log.info("User has a recommendation ", user, recommendation);
    }

    @Override
    public void addShipmentTrackingToUser(Long userId, int shipmentTrackingId) {
        User user = getUserById(userId);
        ShipmentTracking shipmentTracking = shipmentTrackingRepository.findById(shipmentTrackingId).orElseThrow(() -> {
            log.error("ShipmentTracking could not be found , id : ", shipmentTrackingId);
            return new NotFoundException("ShipmentTracking with id " + shipmentTrackingId + "not found");
        });

        user.addShipmentTracking(shipmentTracking);

        saveUser(user);

        log.info("User has a shipment tracking ", user, shipmentTracking);
    }

    @Override
    public void addHistoricalOrderToUser(Long userId, int historicalOrderId) {
        User user = getUserById(userId);
        HistoricalOrder historicalOrder = historicalOrderRepository.findById(historicalOrderId).orElseThrow(() -> {
            log.error("HistoricalOrder could not be found , id : ", historicalOrderId);
            return new NotFoundException("HistoricalOrder with id " + historicalOrderId + "not found");
        });

        user.addHistoricalOrder(historicalOrder);

        saveUser(user);

        log.info("User has a historical order ", user, historicalOrder);
    }


}