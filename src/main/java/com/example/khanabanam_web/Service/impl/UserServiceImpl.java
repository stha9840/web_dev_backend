package com.example.khanabanam_web.Service.impl;

import com.example.khanabanam_web.Entity.User;
import com.example.khanabanam_web.Pojo.UserPojo;
import com.example.khanabanam_web.Repository.UserRepository;
import com.example.khanabanam_web.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(UserPojo userPojo) {
        User user = new User();
        user.setUserName(userPojo.getName());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User updateUser(Integer id, UserPojo userPojo) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserName(userPojo.getName());
            user.setEmail(userPojo.getEmail());
            user.setPassword(userPojo.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
