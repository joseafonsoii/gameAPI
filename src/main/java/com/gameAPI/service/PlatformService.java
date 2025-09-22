package com.gameAPI.service;

import com.gameAPI.dto.request.PlatformRequestDTO;
import com.gameAPI.dto.response.PlatformResponseDTO;
import com.gameAPI.model.Platform;
import com.gameAPI.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository repository;

    public List<PlatformResponseDTO> getPlatforms(){
        return repository.findAll().stream().map(PlatformResponseDTO::fromEntity).toList();
    }

    public Optional<PlatformResponseDTO> getPlatformById(int id){
        return repository.findById(id).map(PlatformResponseDTO::fromEntity);
    }

    public PlatformResponseDTO createPlatform(PlatformResponseDTO dto){
        Platform platform = repository.save(new Platform(dto.getName()));
        return PlatformResponseDTO.fromEntity(platform);
    }

    public Optional<PlatformResponseDTO> updatePlatform(int id, PlatformRequestDTO dto){
        return repository.findById(id).map( platform->{
            platform.setName(dto.getNameDTO());
            return PlatformResponseDTO.fromEntity((Platform) repository.save(platform));
        });
    }

    public void deletePlatform(int id){
        repository.deleteById(id);
    }

    public List<PlatformResponseDTO> searchByName(String name){
        return repository.findByNameContainIgnoreCase(name).
                stream().map(PlatformResponseDTO::fromEntity).toList();
    }
}
