package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    public Song() {
    }

    public Song(Long id, String imgPath, int minutes, String name, LocalDate dateCreate, List<Genre> genres) {
        this.id = id;
        this.imgPath = imgPath;
        this.minutes = minutes;
        this.name = name;
        this.dateCreate = dateCreate;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", minutes=" + minutes +
                ", name='" + name + '\'' +
                ", dateCreate=" + dateCreate +
                ", genres=" + genres +
                '}';
    }
}
