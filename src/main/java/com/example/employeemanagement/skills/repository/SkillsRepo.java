package com.example.employeemanagement.skills.repository;

import com.example.employeemanagement.skills.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skills,Long> {
}
