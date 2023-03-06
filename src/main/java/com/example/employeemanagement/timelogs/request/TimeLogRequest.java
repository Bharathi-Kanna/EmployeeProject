package com.example.employeemanagement.timelogs.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TimeLogRequest {
    private Long projectId;

    private Long employeeId;

    private LocalDateTime logTime;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long loggedHours;

}
