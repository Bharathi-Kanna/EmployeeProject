package com.example.employeemanagement.timesheet.enitity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="TimeSheets")
@Data
@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private long id;
    @Column(name="approval_status")
    private String status;

    @Column(name="billable_status")
    private String billable_status;

}


