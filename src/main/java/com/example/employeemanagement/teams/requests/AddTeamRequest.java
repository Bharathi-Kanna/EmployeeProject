package com.example.employeemanagement.teams.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTeamRequest {
    private Long id;
    private Long project_id;
    private String name;

}
