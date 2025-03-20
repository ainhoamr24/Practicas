package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private String imgPath;
    private LocalDate dateCreate;
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
