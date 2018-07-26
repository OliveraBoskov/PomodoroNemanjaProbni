package com.execom.pomodoro.controller.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddUserToTeamDTO {
    
    private List<AddMemberDTO> userIds = new ArrayList<>();

    public AddUserToTeamDTO(List<AddMemberDTO> userIds) {
        this.userIds = userIds;
    }

    
}
