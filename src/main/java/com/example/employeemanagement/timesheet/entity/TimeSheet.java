package com.example.employeemanagement.timesheet.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="time_sheet")
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private Long Id;
    @Column(name="emp_id")
    private Long employeeId;
    @Column(name="pro_id")
    private Long projectId;
    @Column(name="hours_worked")
    private Long hoursWorked;
    @Column(name="created_time")
    private LocalDateTime logTime;
    @Column(name="totalCost")
    private Long totalCost;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    private List<Long> jobsId;

}
