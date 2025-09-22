package com.gameAPI.repository;

import com.gameAPI.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    List<Platform> findByNameContainIgnoreCase(String name);
}