package org.ubt.profile.service;

import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.profile.model.Recommendation;
import org.ubt.profile.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers() throws InterruptedException;

    void saveUser(User user);

    void removeUser(int id);

    User updateUser(User product);

    User getUserById(int id);

    void addRecommendationToUser(int userId, int recommendationId);

    void addShipmentTrackingToUser(int userId, int shipmentTrackingId);

    void addHistoricalOrderToUser(int userId, int historicalOrderId);

}
