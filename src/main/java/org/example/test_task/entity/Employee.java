package org.example.test_task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.example.test_task.entity.Department;
import org.example.test_task.entity.Position;

import org.example.test_task.enums.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(length = 12, nullable = false, unique = true, columnDefinition = "bpchar(12)")
    private String iin;

    @Column(length = 13, nullable = false, unique = true, columnDefinition = "bpchar(13)")
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate employedAt;

    private LocalDate terminatedAt;

    private String grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmploymentType employmentType = EmploymentType.FULL;

    private BigDecimal salaryBase;

    private String salaryCurrency;

    private String workSchedule;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "manager")
    private Employee manager;
}