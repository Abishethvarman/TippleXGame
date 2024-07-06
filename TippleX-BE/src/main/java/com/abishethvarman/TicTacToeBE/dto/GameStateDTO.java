package com.abishethvarman.TicTacToeBE.dto;

import com.abishethvarman.TicTacToeBE.entity.StateData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameStateDTO {
    private StateData stateData;
}
