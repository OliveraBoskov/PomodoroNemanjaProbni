package com.execom.pomodoro.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "Username", unique = true)
    private String username;

    @NotNull
    @Column(name = "FullName", unique = true)
    private String fullName;

    @NotNull
    @Column(name = "Email", unique = true)
    private String email;

    @NotNull
    private String role;

    @NotNull
    private boolean active;
    
//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    private List<UserToGroup> userToGroup = new ArrayList<>();
//    
//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    private List<Pomodoro> pomodoro = new ArrayList<>();

    public User(@NotNull String username, @NotNull String fullName, @NotNull String email, @NotNull String role) {
        super();
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

}
