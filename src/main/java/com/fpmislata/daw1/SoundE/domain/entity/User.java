package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class User {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthdate;
    private String imgPath;

    public User() {
    }

    public User(Long id, String name, String email, LocalDate birthdate, String imgPath) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
