package com.execom.pomodoro.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddMemberDTO {
    
    private Long userId;
    private Long userRoleId;
    
    public AddMemberDTO(Long userId, Long userRoleId) {
        this.userId = userId;
        this.userRoleId = userRoleId;
    }

}
