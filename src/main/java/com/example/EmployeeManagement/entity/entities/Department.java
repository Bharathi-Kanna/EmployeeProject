package com.example.EmployeeManagement.entity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dep_id")
    private Long departmentId;
    @Column(name="dep_name")
    private String departmentName;
    @JsonIgnore
    private Date dataEnteredDateTime = new Date();
}
