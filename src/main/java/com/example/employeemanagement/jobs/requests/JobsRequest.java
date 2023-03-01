package com.example.employeemanagement.jobs.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class JobsRequest {
    private long id;

    private String jobName;

    private LocalDate startDate;

    private LocalDate endDate;

    private int estimatedHours;

    private int ratePerHour;

    private String billable;

    private String jobStatus;

    private Long projectId;

    private Long employeeId;

}
