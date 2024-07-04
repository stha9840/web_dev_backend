package com.example.khanabanam_web.Controller;

import com.example.khanabanam_web.Entity.User;
import com.example.khanabanam_web.Pojo.UserPojo;
import com.example.khanabanam_web.Service.UserService;
import com.example.khanabanam_web.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public GlobalApiResponse<String> saveUser(@RequestBody UserPojo userPojo) {
        userService.saveUser(userPojo);
        return GlobalApiResponse.<String>builder()
                .data("Saved")
                .statusCode(200)
                .message("User saved successfully")
                .build();
    }

    @GetMapping
    public GlobalApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return GlobalApiResponse.<List<User>>builder()
                .data(users)
                .statusCode(200)
                .message("Users retrieved successfully")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return GlobalApiResponse.<User>builder()
                    .data(user)
                    .statusCode(200)
                    .message("User found with id: " + id)
                    .build();
        } else {
            return GlobalApiResponse.<User>builder()
                    .statusCode(404)
                    .message("User not found with id: " + id)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateUser(@PathVariable Integer id, @RequestBody UserPojo userPojo) {
        User updatedUser = userService.updateUser(id, userPojo);
        if (updatedUser != null) {
            return GlobalApiResponse.<String>builder()
                    .data("Updated")
                    .statusCode(200)
                    .message("User updated successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("User not found with id: " + id + ". Update failed.")
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return GlobalApiResponse.<String>builder()
                    .data("Deleted")
                    .statusCode(200)
                    .message("User deleted successfully")
                    .build();
        } else {
            return GlobalApiResponse.<String>builder()
                    .statusCode(404)
                    .message("User not found with id: " + id + ". Delete failed.")
                    .build();
        }
    }
}
