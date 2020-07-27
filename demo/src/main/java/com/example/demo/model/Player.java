package com.example.demo.model;

import com.example.demo.service.FootballService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="players")
@Table(name="players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int ranking;
    @Enumerated(EnumType.STRING)
    private FootballService.Positions position;
    private boolean available;

    public Player(String name, int ranking, FootballService.Positions position, boolean available) {
        this.name = name;
        this.ranking = ranking;
        this.position = position;
        this.available = available;
    }
}
