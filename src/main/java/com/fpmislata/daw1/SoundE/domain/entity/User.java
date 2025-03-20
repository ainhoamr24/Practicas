package com.fpmislata.daw1.SoundE.domain.entity;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String email;
    private LocalDate birthdate;
    private String imgPath;

    public User() {
    }

    public User(Long id, String username, String email, LocalDate birthdate, String imgPath) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthdate = birthdate;
        setImgPath(imgPath);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
        if(this.imgPath.isEmpty())
            this.imgPath = "/img/icons/icon.svg";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
