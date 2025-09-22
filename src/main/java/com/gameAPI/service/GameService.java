package com.gameAPI.service;

import com.gameAPI.dto.request.GameRequestDTO;
import com.gameAPI.dto.response.GameResponseDTO;
import com.gameAPI.model.Game;
import com.gameAPI.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameResponseDTO> getGames(){
        return gameRepository.findAll().stream().map(GameResponseDTO::fromEntity).toList();
    }

    public Optional<GameResponseDTO> getGameById(int id){
        return gameRepository.findById(id).map(GameResponseDTO::fromEntity);
    }

    public GameResponseDTO createGame(GameResponseDTO dto){
        Game game = gameRepository.save(new Game(dto.getNameDTO()));
        return GameResponseDTO.fromEntity(game);
    }

    public Optional<GameResponseDTO> updateGame(int id, GameRequestDTO dto){
        return gameRepository.findById(id).map( game->{
            game.setName(dto.getNameDTO());
            return GameResponseDTO.fromEntity((Game) gameRepository.save(game));
        });
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }

    public List<GameResponseDTO> searchByName(String name){
        return gameRepository.findByNameContainIgnoreCase(name).
                stream().map(GameResponseDTO::fromEntity).toList();
    }
}
