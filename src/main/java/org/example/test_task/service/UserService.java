package org.example.test_task.service;

import org.example.test_task.entity.User;
import org.example.test_task.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Get all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get one
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    // Update one
    public User updateUser(UUID id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    BeanUtils.copyProperties(updatedUser, user, "id");
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete one
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
