package com.example.employeemanagement.timelogs.repository;

import com.example.employeemanagement.timelogs.entity.TimeLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLogRepo extends JpaRepository<TimeLogs,Long> {

}
