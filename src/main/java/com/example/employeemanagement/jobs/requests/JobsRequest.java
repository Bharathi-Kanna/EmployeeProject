package com.example.employeemanagement.jobs.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobsRequest {
    private long id;

    private String jobName;

    private String startDate;

    private String endDate;

    private int estimatedHours;

    private int ratePerHour;

    private String billable;

    private String job_Status;


}
