package com.abishethvarman.TicTacToeBE.service;

import com.abishethvarman.TicTacToeBE.dto.GameStateDTO;
import com.abishethvarman.TicTacToeBE.entity.StateData;
import com.abishethvarman.TicTacToeBE.repository.StateDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameStateService {
    private final StateDataRepository stateDataRepository;

    @Transactional
    public StateData saveStateData(GameStateDTO gameStateDTO) {
        return stateDataRepository.save(gameStateDTO.getStateData());
    }

    public List<StateData> getAllState() {
        Pageable pageable = PageRequest.of(0, 12, Sort.by(Sort.Direction.DESC, "id"));
        return stateDataRepository.findAll(pageable).getContent();

//        return stateDataRepository.findAll();
    }

//    public List<StateData> getLast10Games() {
//        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
//        return stateDataRepository.findAll(pageable).getContent();
//    }
}