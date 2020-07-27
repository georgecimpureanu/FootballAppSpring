package com.example.demo.dao;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Integer> {

    @Query("FROM players WHERE ranking > ?1")
    List<Player> findPlayersWithRankingGT(int ranking);
}
