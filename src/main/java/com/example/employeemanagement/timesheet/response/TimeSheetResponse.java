package com.example.employeemanagement.timesheet.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeSheetResponse {
    private Long Id;
    private Long employeeId;
    private Long projectId;
    private Long hoursWorked;
    private LocalDateTime logTime;
    private Long totalCost;
}
