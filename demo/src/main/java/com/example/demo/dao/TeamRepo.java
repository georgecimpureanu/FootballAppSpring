package com.example.demo.dao;

import com.example.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
}
