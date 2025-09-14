package org.example.test_task.dto;


import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmployeeCreateRequestDto {
    private String fullName;
    private String iin;
    private String phone;
    private String email;
    private LocalDate employedAt;
    private String grade;
    private String status;
    private String employmentType;
    private BigDecimal salaryBase;
    private String salaryCurrency;
    private String workSchedule;
    private UUID departmentId;
    private UUID positionId;
    private UUID managerId;
}
