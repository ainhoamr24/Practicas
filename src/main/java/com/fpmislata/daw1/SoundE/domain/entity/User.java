package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 20, message = "El nombre no puede contener más de 20 carácteres")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe de tener un formato válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe de contener almenos 8 carácteres")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate birthdate;

    @Column(nullable = true)
    private String imgPath;

    public User(Long id, String name, String email, String password, LocalDate birthdate, String imgPath) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        setImgPath(imgPath);
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
        if(imgPath.isEmpty())
            this.imgPath = "/img/icon.svg";

    }
}
