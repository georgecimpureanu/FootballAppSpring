package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/football")
public class PlayerController {

    @Autowired
    private FootballService footballService;

    @PostMapping("/players")
    @ResponseBody
    public Player addPlayer(@RequestBody Player player) {
        footballService.addPlayer(player);
        return player;
    }

    @GetMapping("/players")
    @ResponseBody
    public List<Player> getPlayers() {
        return footballService.getPlayers();
    }

    @GetMapping("/players/rank")
    @ResponseBody
    public List<Player> getPlayerByRanking(@RequestParam int ranking) {
        return footballService.findPlayersWithRankingGT(ranking);
    }

    @PutMapping("/players/{id}")
    @ResponseBody
    public Player updatePlayer(@PathVariable(value = "id") int id,
                               @RequestBody Player player) {
        footballService.updatePlayer(id, player);
        return player;
    }

    @DeleteMapping("/players/{id}")
    @ResponseBody
    public void deletePlayer(@PathVariable int id) throws Exception {
        footballService.deletePlayer(id);
    }

}
