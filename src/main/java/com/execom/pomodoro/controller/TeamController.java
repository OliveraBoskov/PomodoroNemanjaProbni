package com.execom.pomodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.execom.pomodoro.controller.dto.AddUserToTeamDTO;
import com.execom.pomodoro.controller.dto.TeamDTO;
import com.execom.pomodoro.controller.dto.TeamInfoDTO;
import com.execom.pomodoro.domain.Team;
import com.execom.pomodoro.service.Mapper;
import com.execom.pomodoro.service.TeamService;

@RestController
@RequestMapping("api/team")
public class TeamController {

    private TeamService teamService;
    private Mapper mapper;

    @Autowired
    public TeamController(TeamService teamService, Mapper mapper) {
        this.teamService = teamService;
        this.mapper = mapper;
    }
    
    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO){
        Team team = teamService.createTeam(teamDTO.getTeam().getName(), teamDTO.getTeam().getDescription());
        return new ResponseEntity<>(mapper.teamToTeamDTO(team), HttpStatus.CREATED);
    }
    
    @GetMapping()
    public ResponseEntity<List<TeamDTO>> getAllTeams(){
        List<Team> tempList = teamService.getAllTeams();
        List<TeamDTO> temp2list = mapper.teamListToTeamDTOList(tempList);
        return new ResponseEntity<>(temp2list, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getSingleUser(@PathVariable Long id){
        Team team = teamService.getSingleTeam(id);
        return new ResponseEntity<>(mapper.teamToTeamDTO(team), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> editTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO){
        Team team = teamService.editTeam(id, teamDTO.getTeam().getName(), teamDTO.getTeam().getDescription(),
                teamDTO.getTeam().isActive());
        if(team == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(mapper.teamToTeamDTO(team), HttpStatus.OK);
    }
    
    @PutMapping("/{id}/add-users-to-team")
    public ResponseEntity<TeamDTO> addUsersToTeam(@PathVariable Long id, @RequestBody AddUserToTeamDTO addUserToTeamDTO){
        Team team = teamService.addUsersToTeam(addUserToTeamDTO.getUserIds(), id);
        return new ResponseEntity<>(mapper.teamToTeamDTO(team), HttpStatus.OK);
    }
    
    @GetMapping("/{id}/users-from-team")
    public ResponseEntity<TeamInfoDTO> usersFromTeam(@PathVariable Long id){
        TeamInfoDTO teamInfo = new TeamInfoDTO();
        teamInfo.setUserDto(mapper.userListToUserDTOList(teamService.usersFromTeam(id)));
        teamInfo.setTeamDto(mapper.teamToTeamDTO(teamService.getSingleTeam(id)));
        return new ResponseEntity<>(teamInfo, HttpStatus.OK);
    }
    
    
    
    
}
