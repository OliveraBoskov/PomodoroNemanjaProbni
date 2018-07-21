package com.execom.pomodoro.controller.dto;

import java.util.List;

public class TeamInfoDTO {

    private TeamDTO teamDto;
    private List<UserDTO> userDto;
    
    public TeamInfoDTO() {
        
    }
    
    public TeamInfoDTO(TeamDTO teamDto, List<UserDTO> userDto) {
        this.teamDto = teamDto;
        this.userDto = userDto;
    }

    public TeamDTO getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDTO teamDto) {
        this.teamDto = teamDto;
    }

    public List<UserDTO> getUserDto() {
        return userDto;
    }

    public void setUserDto(List<UserDTO> userDto) {
        this.userDto = userDto;
    }
    
    
}
