package com.abishethvarman.TicTacToeBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "state_data_tbl")
public class StateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @OneToMany(targetEntity = GameState.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GS_fk",referencedColumnName = "id")
    private List<GameState> state;

}
