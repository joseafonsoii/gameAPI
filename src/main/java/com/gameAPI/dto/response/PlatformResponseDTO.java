package com.gameAPI.dto.response;

import com.gameAPI.model.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatformResponseDTO {

    private int id;
    private String name;

    public static PlatformResponseDTO fromEntity(Platform platform){
        return new PlatformResponseDTO(platform.getId(),platform.getName());
    }
    public PlatformResponseDTO(String name){
        this.name = name;
    }
}
