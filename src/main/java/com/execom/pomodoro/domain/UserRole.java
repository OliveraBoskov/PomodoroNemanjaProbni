package com.execom.pomodoro.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRole {
    
    private Long id;
    private String name;
    private String description;
    
    public UserRole(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
