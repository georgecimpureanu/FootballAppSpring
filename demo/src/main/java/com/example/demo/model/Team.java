package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name="team")
@Table(name="team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private Set<Player> membersOfTeam;
}
