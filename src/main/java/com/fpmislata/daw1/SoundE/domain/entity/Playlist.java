package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private String imgPath;
    private String artist;
    private String artistPath;
    private LocalDate dateCreate;
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(Long id, String name, String imgPath, String artist, String artistPath, LocalDate dateCreate, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.artist = artist;
        this.artistPath = artistPath;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistPath() {
        return artistPath;
    }

    public void setArtistPath(String artistPath) {
        this.artistPath = artistPath;
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
                ", artist='" + artist + '\'' +
                ", artistPath='" + artistPath + '\'' +
                ", dateCreate=" + dateCreate +
                ", songs=" + songs +
                '}';
    }
}
