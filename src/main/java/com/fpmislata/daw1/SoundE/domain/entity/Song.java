package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Song {
    private Long id;
    private String imgPath;
  
    @Column(nullable = false)
    private Long seconds;
    private String name;
    private String artist;
    private String artistImgPath;
    private LocalDate dateCreate;
    private List<Genre> genres;
    private Duration duration;

    public Song() {
    }

    public Song(Long id, String imgPath, Long seconds, String name, String artist, String artistImgPath, LocalDate dateCreate, List<Genre> genres) {
        this.id = id;
        this.imgPath = imgPath;
        this.seconds = seconds;
        this.name = name;
        this.artist = artist;
        this.artistImgPath = artistImgPath;
        this.dateCreate = dateCreate;
        this.genres = genres;
        setDuration(seconds);
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

    public Long getSeconds() {
        return seconds;
    }

    public void setSeconds(Long seconds) {
        this.seconds = seconds;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(Long seconds) {
        this.duration = (seconds != null && seconds > 0)
                ? Duration.ofSeconds(seconds)
                : Duration.ZERO;
    }

    public String getFormattedDuration() {
        return String.format("%02d:%02d", duration.toMinutes(), duration.getSeconds() % 60);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", seconds=" + seconds +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                ", dateCreate=" + dateCreate +
                ", genres=" + genres +
                ", artist='" + artist + '\'' +
                ", artistImgPath=" + artistImgPath +
                '}';
    }
}
