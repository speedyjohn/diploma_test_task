package org.example.test_task.service;

import org.example.test_task.entity.Department;
import org.example.test_task.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Create one
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get all
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get one
    public Optional<Department> getDepartmentById(UUID id) {
        return departmentRepository.findById(id);
    }

    // Update one
    public Department updateDepartment(UUID id, Department updatedDepartment) {
        return departmentRepository.findById(id)
                .map(department -> {
                    BeanUtils.copyProperties(updatedDepartment, department, "id");
                    return departmentRepository.save(department);
                })
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    // Delete one
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }
}
