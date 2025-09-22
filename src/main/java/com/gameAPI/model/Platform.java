package com.gameAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="platform")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Platform {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    public Platform(String name) {
        this.name = name;
    }
}
