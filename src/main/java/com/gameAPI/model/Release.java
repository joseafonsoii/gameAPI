package com.gameAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game_release")
@IdClass(ReleaseId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Release {

    @Id
    @ManyToOne
    @JoinColumn(name = "platform_id" , referencedColumnName = "id")
    private Platform platform;

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id" , referencedColumnName = "id")
    private Game game;

    @Column(name = "year", nullable = false)
    private  int year;
}
