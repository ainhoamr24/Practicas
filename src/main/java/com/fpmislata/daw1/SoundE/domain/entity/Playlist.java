package com.fpmislata.daw1.SoundE.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
