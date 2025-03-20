package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private Long id;
    private String name;
    private String imgPath;
    private List<Song> songs;

    public Genre() {
    }

    public Genre(Long id, String name, String imgPath, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", songs=" + songs +
                '}';
    }
}
