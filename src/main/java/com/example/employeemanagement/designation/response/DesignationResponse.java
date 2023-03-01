package com.example.employeemanagement.designation.response;

import com.example.employeemanagement.designation.entity.Designation;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DesignationResponse {
    private Long id;
    private String name;

    public DesignationResponse(Designation designation){
        this.id = designation.getDesignationId();
        this.name = designation.getDesignationName();
    }
}
