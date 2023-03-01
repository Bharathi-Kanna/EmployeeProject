package com.example.employeemanagement.employeeproject.repository;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepo extends JpaRepository<EmployeeProject,Long> {
}
