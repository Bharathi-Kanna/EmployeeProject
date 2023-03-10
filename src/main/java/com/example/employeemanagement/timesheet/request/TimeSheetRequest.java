package com.example.employeemanagement.timesheet.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TimeSheetRequest {
    private Long Id;
    private Long employeeId;
    private Long projectId;
    private Long hoursWorked;
    private LocalDateTime logTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long totalCost;
}
