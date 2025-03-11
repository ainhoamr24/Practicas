package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private LocalDate dateCreate;

    @ManyToMany
    @JoinTable(
            name = "tb_listSongs",
            joinColumns = @JoinColumn(name = "lsn_list_id"),
            inverseJoinColumns = @JoinColumn(name = "lsn_song_id")
    )
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(Long id, String name, String imgPath, LocalDate dateCreate, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.dateCreate = dateCreate;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", dateCreate=" + dateCreate +
                ", songs=" + songs +
                '}';
    }
}
