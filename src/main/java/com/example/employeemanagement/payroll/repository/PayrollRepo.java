package com.example.employeemanagement.payroll.repository;

import com.example.employeemanagement.payroll.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll,Long> {

}
