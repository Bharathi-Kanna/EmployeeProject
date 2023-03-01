package com.example.employeemanagement.employee.repository;

import com.example.employeemanagement.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
     List<Employee> findByDepartmentId(Long id);
     List<Employee> findByDesignationId(Long id);
     List<Employee> findByOrderByExperienceDesc();
     @Query(value="select e.emp_name from employee as e left join payroll as b on e.payroll_payroll_id = b.payroll_id order by b.salary DESC", nativeQuery = true)
     List<String> sortBySalary();
}
