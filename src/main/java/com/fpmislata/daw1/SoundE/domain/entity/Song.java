package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private int minutes;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateCreate;

    @ManyToMany
    @JoinTable(
            name = "tb_songGenres",
            joinColumns = @JoinColumn(name = "sgr_song_id"),
            inverseJoinColumns = @JoinColumn(name = "sgr_genre_id")
    )
    private List<Genre> genres;
}
