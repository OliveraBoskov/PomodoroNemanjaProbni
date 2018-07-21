package com.execom.pomodoro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.execom.pomodoro.controller.dto.UserDTO;
import com.execom.pomodoro.domain.User;
import com.execom.pomodoro.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String fullName, String email, String role) {
        User user = new User(username, fullName, email, role);
        user.setActive(true);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByActive(true);
    }

    public User getSingleUser(Long id) {
        User user = userRepository.findOneById(id);
        return user;
    }

    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        user.setActive(false);
        userRepository.save(user);
    }

    public User editUser(Long id, String username, String fullName, String email, String role, boolean active) {
        User user = userRepository.getOne(id);
        user.setUsername(username);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setRole(role);
        user.isActive();

        return userRepository.save(user);
    }

}
