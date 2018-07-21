package com.execom.pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.execom.pomodoro.controller.dto.TeamDTO;
import com.execom.pomodoro.controller.dto.UserDTO;
import com.execom.pomodoro.domain.Team;
import com.execom.pomodoro.domain.User;

@Service
public class Mapper {
    
    public UserDTO userToUserDTO(User u) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(u);
        return userDTO;
        }
    
    public List<UserDTO> userListToUserDTOList(List<User> userList) {
        List<UserDTO> tempList = new ArrayList<>();
        for(User u: userList) {
         tempList.add(userToUserDTO(u));
        }
        return tempList;
    }
    
    public TeamDTO teamToTeamDTO(Team t) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeam(t);
        return teamDTO;
    }
    
    public List<TeamDTO> teamListToTeamDTOList(List<Team> teamList){
        List<TeamDTO> tempList = new ArrayList<>();
        for(Team t: teamList){
            tempList.add(teamToTeamDTO(t));
        }
        return tempList;
    }

}
