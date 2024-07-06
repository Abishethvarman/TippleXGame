package com.abishethvarman.TicTacToeBE.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="game_state_tbl")
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_state_id")
    private Long Game_State_Id;
    @Column(name = "`value`")
    private String value;
    private int game_index;
}