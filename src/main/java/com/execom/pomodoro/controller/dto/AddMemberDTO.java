package com.execom.pomodoro.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddMemberDTO {
    
    private Long userId;
    private Long userRoleId;

}
