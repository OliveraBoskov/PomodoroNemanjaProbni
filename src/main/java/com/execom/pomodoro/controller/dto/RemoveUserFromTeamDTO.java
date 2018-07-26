package com.execom.pomodoro.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RemoveUserFromTeamDTO {
    
    private Long userId;

    public RemoveUserFromTeamDTO(Long userId) {
        this.userId = userId;
    }
}
