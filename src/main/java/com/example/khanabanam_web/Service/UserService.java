package com.example.khanabanam_web.Service;

import com.example.khanabanam_web.Entity.User;
import com.example.khanabanam_web.Pojo.UserPojo;
import java.util.List;

public interface UserService {
    void saveUser(UserPojo userPojo);
    List<User> getAllUsers();
    User getUserById(Integer id);
    User updateUser(Integer id, UserPojo userPojo);
    void deleteUser(Integer id);
}
