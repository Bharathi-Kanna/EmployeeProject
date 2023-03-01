package com.example.employeemanagement.jobs.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddEmpJobRequest {
    private Long id;
    private List<Long> employeeId;

}






