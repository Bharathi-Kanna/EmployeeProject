package com.example.employeemanagement.employeeproject.repository;

import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepo extends JpaRepository<EmployeeProject,Long> {
}
