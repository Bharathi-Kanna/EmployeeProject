package com.example.EmployeeManagement.repository.entityrepo;

import com.example.EmployeeManagement.entity.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
