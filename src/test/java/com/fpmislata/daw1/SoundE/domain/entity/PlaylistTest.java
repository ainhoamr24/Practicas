package com.fpmislata.daw1.SoundE.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    @ParameterizedTest(name = "(id = {0}, name = {1}, imgPath = {2}, dateCreate = {3}, songsCount = {4})")
    @DisplayName("Playlist::Constructor")
    @CsvSource({
            "1, Mix Alegre, /img/playlist/1/cover1.jpg, 2020-03-12, 1",
            "2, Mix Triste, /img/playlist/2/cover2.jpg, 2018-06-15, 2"
    })
    void playlistConstructorTest(Long id, String name, String imgPath, String dateCreateStr, int songsCount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate dateCreate = LocalDate.parse(dateCreateStr, formatter);

        List<Song> songs = Arrays.asList(new Song(), new Song()).subList(0, songsCount);

        Playlist playlist = new Playlist();
        playlist.setId(id);
        playlist.setName(name);
        playlist.setImgPath(imgPath);
        playlist.setDateCreate(dateCreate);
        playlist.setSongs(songs);

        assertAll(
                () -> assertEquals(playlist.getId(), id),
                () -> assertEquals(playlist.getName(), name),
                () -> assertEquals(playlist.getImgPath(), imgPath),
                () -> assertEquals(playlist.getDateCreate(), dateCreate),
                () -> assertEquals(playlist.getSongs().size(), songsCount)
        );
    }
}
