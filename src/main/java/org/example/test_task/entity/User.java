package org.example.test_task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

// Users table entity
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;
}