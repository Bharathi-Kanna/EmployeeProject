package com.example.EmployeeManagement.repository.entityrepo;

import com.example.EmployeeManagement.entity.entities.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation,Long> {
}
