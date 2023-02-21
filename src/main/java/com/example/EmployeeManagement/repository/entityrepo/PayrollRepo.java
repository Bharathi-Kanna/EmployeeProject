package com.example.EmployeeManagement.repository.entityrepo;

import com.example.EmployeeManagement.entity.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll,Long> {

}
