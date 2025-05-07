package com.fpmislata.daw1.SoundE.domain.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private Long id;
    private String name;
    private String imgPath;
    private String artist;
    private String artistImgPath;
    private LocalDate dateCreate;
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(Long id, String name, String imgPath, String artist, String artistImgPath, LocalDate dateCreate, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.artist = artist;
        this.artistImgPath = artistImgPath;
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

    public String getArtistImgPath() {
        return artistImgPath;
    }

    public void setArtistImgPath(String artistImgPath) {
        this.artistImgPath = artistImgPath;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(id, playlist.id) && Objects.equals(name, playlist.name) && Objects.equals(imgPath, playlist.imgPath) && Objects.equals(artist, playlist.artist) && Objects.equals(artistImgPath, playlist.artistImgPath) && Objects.equals(dateCreate, playlist.dateCreate) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imgPath, artist, artistImgPath, dateCreate, songs);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", artist='" + artist + '\'' +
                ", artistImgPath='" + artistImgPath + '\'' +
                ", dateCreate=" + dateCreate +
                ", songs=" + songs +
                '}';
    }
}
