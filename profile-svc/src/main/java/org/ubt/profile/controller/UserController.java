package org.ubt.profile.controller;

import org.springframework.web.bind.annotation.*;
import org.ubt.profile.model.User;
import org.ubt.profile.service.UserService;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() throws InterruptedException {
        return userService.getUsers();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/{userId}/recommendation/{recommendationId}")
    public void addRecommendationToUser(@PathVariable int userId, @PathVariable int recommendationId) {
        userService.addRecommendationToUser(userId, recommendationId);
    }

    @PostMapping("/{userId}/shipmentTracking/{shipmentTrackingId}")
    public void addShipmentTrackingToUser(@PathVariable int userId, @PathVariable int shipmentTrackingId) {
        userService.addShipmentTrackingToUser(userId, shipmentTrackingId);
    }

    @PostMapping("/{userId}/historicalOrder/{historicalOrderId}")
    public void addHistoricalOrderToUser(@PathVariable int userId, @PathVariable int historicalOrderId) {
        userService.addHistoricalOrderToUser(userId, historicalOrderId);
    }

}
