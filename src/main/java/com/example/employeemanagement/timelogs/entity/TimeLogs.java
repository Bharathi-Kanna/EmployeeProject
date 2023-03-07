package com.example.employeemanagement.timelogs.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="TimeLogs")
@Data
@Entity
public class TimeLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name="project_id")
    private Long projectId;

    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="log_time")
    private LocalDateTime logTime;

    @Column(name="logged_hours")
    private Long loggedHours;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;


}
