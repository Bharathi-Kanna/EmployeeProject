package com.example.employeemanagement.teams.response;

import com.example.employeemanagement.teams.entity.Teams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamResponse {
    private Long id;
    private String name;
    private List<Long> employee_id;
    private Long project_id;
    public TeamResponse(Teams team){
        this.id = team.getId();
        this.name = team.getName();
    }
}
