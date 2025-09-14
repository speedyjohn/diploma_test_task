package org.example.test_task.repository;

import org.example.test_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Just an example of JPA repo
    Optional<User> findByUsername(String username);
}
