package com.execom.pomodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.execom.pomodoro.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    
    UserRole findOneById(Long id);

}
