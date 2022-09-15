package org.ubt.profile.service;

import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.profile.model.Recommendation;
import org.ubt.profile.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers() throws InterruptedException;

    void saveUser(User user);

    void removeUser(Long id);

    User updateUser(User product);

    User getUserById(Long id);

    void addRecommendationToUser(Long userId, int recommendationId);

    void addShipmentTrackingToUser(Long userId, int shipmentTrackingId);

    void addHistoricalOrderToUser(Long userId, int historicalOrderId);

}
