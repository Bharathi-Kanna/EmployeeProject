package com.example.EmployeeManagement.repository.entityrepo;

import com.example.EmployeeManagement.entity.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    public List<Employee> findByDepartmentId(Long id);
    public List<Employee> findByDesignationId(Long id);
}
