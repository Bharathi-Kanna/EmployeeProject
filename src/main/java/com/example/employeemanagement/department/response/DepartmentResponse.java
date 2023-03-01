package com.example.employeemanagement.department.response;


import com.example.employeemanagement.department.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponse {
    private Long id;
    private String name;
    public DepartmentResponse(Department department){
        this.id = department.getDepartmentId();
        this.name= department.getDepartmentName();
    }
}
