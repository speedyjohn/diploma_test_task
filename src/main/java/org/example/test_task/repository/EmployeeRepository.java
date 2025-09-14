package org.example.test_task.repository;

import org.example.test_task.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    // Just an example
    Optional<Employee> findTop4ByOrderBySalaryBaseDesc();
}
