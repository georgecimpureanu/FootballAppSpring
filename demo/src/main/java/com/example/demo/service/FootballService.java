package com.example.demo.service;

import com.example.demo.dao.PlayerRepo;
import com.example.demo.dao.TeamRepo;
import com.example.demo.model.Player;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class FootballService {

    @Autowired
    PlayerRepo playerRepo;
    @Autowired
    TeamRepo teamRepo;

    public static enum Positions {
        FRONT,
        MIDDLE,
        BACK
    }

    @Transactional
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Transactional
    public void addPlayer(Player player) {
        playerRepo.save(player);
    }

    @Transactional
    public void updatePlayer(int id, Player player) {
        Optional<Player> p = findPlayerById(id);
        if (!p.isPresent())
            playerRepo.save(player);
        else {
            Player oldPlayer = p.get();
            oldPlayer.setName(player.getName());
            oldPlayer.setAvailable(player.isAvailable());
            oldPlayer.setPosition(player.getPosition());
            oldPlayer.setRanking(player.getRanking());
            playerRepo.save(oldPlayer);
        }
    }

    @Transactional
    public Optional<Player> findPlayerById(int id) { return playerRepo.findById(id); }

    @Transactional
    public void deletePlayer(int id) throws Exception {
        Optional<Player> player = findPlayerById(id);
        if (!player.isPresent())
            throw new Exception("No player found with this id");
        else
            playerRepo.delete(player.get());
    }

    @Transactional
    public List<Player> findPlayersWithRankingGT(int ranking) {
        return playerRepo.findPlayersWithRankingGT(ranking);
    }

    @Transactional
    public void addTeam(Team team) {
        teamRepo.save(team);
    }

    @Transactional
    public List<Team> getTeams() {
        return teamRepo.findAll();
    }

    @Transactional
    public Team getTeam(int id) {
        return teamRepo.findById(id).get();
    }
}
