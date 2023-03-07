package com.example.employeemanagement.timesheet.repository;

import com.example.employeemanagement.timesheet.controller.TimeSheetController;
import com.example.employeemanagement.timesheet.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetRepo extends JpaRepository<TimeSheet, Long> {
}
