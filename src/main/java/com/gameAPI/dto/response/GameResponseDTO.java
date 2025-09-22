package com.gameAPI.dto.response;


import com.gameAPI.model.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameResponseDTO {
    private int idDTO;
    private String nameDTO;

    public static GameResponseDTO fromEntity(Game game){
        return new GameResponseDTO(game.getId(),game.getName());
    }
}
