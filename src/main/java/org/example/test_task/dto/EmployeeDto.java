package org.example.test_task.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate employedAt;
    private LocalDate terminatedAt;
    private String grade;
    private String status;
    private String employmentType;
    private BigDecimal salaryBase;
    private String salaryCurrency;
    private String workSchedule;
    private String departmentName;
    private String positionName;
    private UUID managerId;
}
