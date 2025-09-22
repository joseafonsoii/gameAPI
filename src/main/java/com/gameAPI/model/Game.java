package com.gameAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    public Game(String nameDTO) {
    }
}
