package com.execom.pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.execom.pomodoro.domain.Team;
import com.execom.pomodoro.domain.User;
import com.execom.pomodoro.domain.UserToGroup;
import com.execom.pomodoro.repository.TeamRepository;
import com.execom.pomodoro.repository.UserRepository;
import com.execom.pomodoro.repository.UserToGroupRepository;

@Service
public class TeamService {
    
    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private UserToGroupRepository userToGroupRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, UserRepository userRepository,
            UserToGroupRepository userToGroupRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.userToGroupRepository = userToGroupRepository;
    }
    
    public Team createTeam(String name, String description){
        Team team = new Team(name, description);
        team.setActive(true);
        return teamRepository.save(team);
    }
    
    public List<Team> getAllTeams(){
        return teamRepository.findAllByActive(true);
    }
    
    public Team getSingleTeam(Long id){
        Team team = teamRepository.findOneById(id);
        return team;
    }
    
    public void deleteTeam(Long id) {
        Team team = teamRepository.getOne(id);
        team.setActive(false);
        teamRepository.save(team);
    }
    
    public Team editTeam(Long id, String name, String description, boolean active){
        Team team = teamRepository.getOne(id);
        team.setName(name);
        team.setDescription(description);
        team.isActive();
        
        return teamRepository.save(team);
    }
    public Team addUsersToTeam(List<Long> userIds, Long teamId){
        Team team = teamRepository.findOneById(teamId);
        for(Long l: userIds){
            User user = userRepository.findOneById(l);
            UserToGroup userToGroup = new UserToGroup();
            userToGroup.setUser(user);
            userToGroup.setTeam(team);
            userToGroupRepository.save(userToGroup);
//            user.getUserToGroup().add(userToGroup);
//            userRepository.save(user);
//            team.getUserToGroup().add(userToGroup);
        }
        
        return teamRepository.save(team);
        
        
    }
    
    public List<User> usersFromTeam(Long id){
        Team team = teamRepository.findOneById(id);
        List<UserToGroup> tempList = userToGroupRepository.findAllByTeam(team);
        List<User> users = new ArrayList<>();
        for(UserToGroup u: tempList){
            users.add(u.getUser());
        }
        
        return users;
    }
    
    

}
