package com.example.employeemanagement.teams.repository;

import com.example.employeemanagement.teams.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepo extends JpaRepository<Teams,Long> {

    List<Teams> findByProject(Long Id);

}
