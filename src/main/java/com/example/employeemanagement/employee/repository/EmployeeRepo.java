package com.example.employeemanagement.employee.repository;

import com.example.employeemanagement.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
     List<Employee> findByDepartmentId(Long id);
     List<Employee> findByDesignationId(Long id);
     List<Employee> findByOrderByExperienceDesc();
}
