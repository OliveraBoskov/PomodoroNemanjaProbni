package com.execom.pomodoro.controller.dto;

import com.execom.pomodoro.domain.Team;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamDTO {
    
    private Team team;

    public TeamDTO(Team team) {
        this.team = team;
    }
    
    

}
