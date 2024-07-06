package com.abishethvarman.TicTacToeBE.repository;
import com.abishethvarman.TicTacToeBE.entity.GameState;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameStateRepository extends JpaRepository<GameState, Long> {
}
