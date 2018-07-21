package com.execom.pomodoro.controller.dto;

import com.execom.pomodoro.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private User user;

    public UserDTO(User user) {
        this.user = user;
    }
    
    
    
    

    
}
