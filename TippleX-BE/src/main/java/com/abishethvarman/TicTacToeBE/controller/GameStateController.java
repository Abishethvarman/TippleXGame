package com.abishethvarman.TicTacToeBE.controller;

import com.abishethvarman.TicTacToeBE.dto.GameStateDTO;
import com.abishethvarman.TicTacToeBE.entity.StateData;
import com.abishethvarman.TicTacToeBE.service.GameStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GameStateController {

    @GetMapping("/test")
    private String helloWolrd(){
        return "Its working in port 8080";
    }

    private final GameStateService gameStateService;
    @PostMapping("/saveState")
    public ResponseEntity<List<StateData>> saveState(@RequestBody GameStateDTO gameStateDTO)
    {
        StateData storedState = gameStateService.saveStateData(gameStateDTO);
        if(storedState == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(getAllState());
    }

    @GetMapping("/getAllState")
    public List<StateData> getAllState(){
        return gameStateService.getAllState();
    }

    @GetMapping("/getLast10Games")
    public List<StateData> getLast10Games(){
        return gameStateService.getAllState();
    }

}