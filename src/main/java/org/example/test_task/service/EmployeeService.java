package org.example.test_task.service;

import org.example.test_task.repository.EmployeeRepository;
import org.example.test_task.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create one
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get one
    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    // Update one
    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    BeanUtils.copyProperties(updatedEmployee, employee, "id");
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Delete one
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
