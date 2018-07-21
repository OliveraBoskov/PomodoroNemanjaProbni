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
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Team")
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    
//    @OneToMany(mappedBy = "team")
//    private List<UserToGroup> userToGroup = new ArrayList<>();

    @NotNull
    @Column(name = "Name", unique = true)
    @Size(max = 15)
    private String name;

    @Column(name = "description")
    private String description;

    public Team(@NotNull @Size(max = 15) String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    private boolean active;
    
    
    
}
