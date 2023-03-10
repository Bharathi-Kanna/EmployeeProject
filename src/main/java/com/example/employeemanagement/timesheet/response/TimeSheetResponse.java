package com.example.employeemanagement.timesheet.response;

import com.example.employeemanagement.timesheet.entity.TimeSheet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TimeSheetResponse {
    private Long Id;
    private Long employeeId;
    private String employeeName;
    private String projectName;
    private Long projectId;
    private Long hoursWorked;
    private LocalDateTime logTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long totalCost;


    public TimeSheetResponse(TimeSheet timeSheet){
        this.Id = timeSheet.getId();
        this.employeeId= timeSheet.getEmployeeId();
        this.projectId= timeSheet.getProjectId();
        this.logTime= timeSheet.getLogTime();
        this.hoursWorked = timeSheet.getHoursWorked();
        this.totalCost = timeSheet.getTotalCost();
        this.startDate = timeSheet.getStartDate();
        this.endDate = timeSheet.getEndDate();
    }
}
