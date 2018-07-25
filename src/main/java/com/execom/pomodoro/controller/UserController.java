package com.execom.pomodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.execom.pomodoro.controller.dto.TeamDTO;
import com.execom.pomodoro.controller.dto.UserDTO;
import com.execom.pomodoro.domain.User;
import com.execom.pomodoro.service.Mapper;
import com.execom.pomodoro.service.TeamService;
import com.execom.pomodoro.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    
    private TeamService teamService;
    
    private Mapper mapper;
    
    @Autowired
    public UserController(UserService userService, Mapper mapper, TeamService teamService) {
        this.userService = userService;
        this.mapper = mapper;
        this.teamService = teamService;
    }
    
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<User> tempList = userService.getAllUsers();
        List<UserDTO> temp2List = mapper.userListToUserDTOList(tempList);
        return new ResponseEntity<>(temp2List, HttpStatus.OK);
//        return new ResponseEntity<>(mapper.userListToUserDTOList(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable Long id) {
        User user = userService.getSingleUser(id);
        return new ResponseEntity<>(mapper.userToUserDTO(user), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO.getUser().getUsername(), userDTO.getUser().getFullName(), userDTO.getUser().getEmail(),
                userDTO.getUser().getRole());

        return new ResponseEntity<>(mapper.userToUserDTO(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        User user = userService.editUser(id, userDTO.getUser().getUsername(), userDTO.getUser().getFullName(), userDTO.getUser().getEmail(), 
                userDTO.getUser().getRole(), userDTO.getUser().isActive());
        if(user == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(mapper.userToUserDTO(user), HttpStatus.OK);
    }
    
    @GetMapping("/{id}/teams-from-user")
    public ResponseEntity<List<TeamDTO>> teamsFromUser(@PathVariable Long id){
        List<TeamDTO> teams = mapper.teamListToTeamDTOList(teamService.teamsFromUser(id));
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    
    @GetMapping("/login")
    public String login(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }
}
