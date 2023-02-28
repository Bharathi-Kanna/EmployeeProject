package com.example.employeemanagement.designation.repository;

import com.example.employeemanagement.designation.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation,Long> {
}
