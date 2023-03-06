package com.example.employeemanagement.timelogs.response;

import com.example.employeemanagement.timelogs.entity.TimeLogs;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TimeLogResponse {

    private Long id;
    private String projectName;
    private String employeeName;
    private LocalDateTime logTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long loggedHours;

    public TimeLogResponse(TimeLogs timeLogs){
        this.id = timeLogs.getId();
        this.logTime = timeLogs.getLogTime();
        this.startDate = timeLogs.getStartDate();
        this.endDate = timeLogs.getEndDate();
        this.loggedHours = timeLogs.getLoggedHours();
    }
}
