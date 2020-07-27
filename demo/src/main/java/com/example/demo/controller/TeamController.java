package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import com.example.demo.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/football")
public class TeamController {

    @Autowired
    private FootballService footballService;

    @PostMapping("/team")
    @ResponseBody
    public Team addTeam(@RequestBody Team team) {
        footballService.addTeam(team);
        return team;
    }

    @GetMapping("/teams")
    @ResponseBody
    public List<Team> getTeams() {
        return footballService.getTeams();
    }

    @GetMapping("/teams/{id}")
    @ResponseBody
    public Team getTeam(@PathVariable int id) {
        return footballService.getTeam(id);
    }
}

