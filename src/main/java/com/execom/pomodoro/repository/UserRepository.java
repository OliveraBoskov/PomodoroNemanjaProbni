package com.execom.pomodoro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.execom.pomodoro.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findAllByActive(boolean active);
    User findOneById(Long id);
}
