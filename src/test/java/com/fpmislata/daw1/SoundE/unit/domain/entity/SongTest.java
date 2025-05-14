package com.fpmislata.daw1.SoundE.unit.domain.entity;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @ParameterizedTest(name = "(id = {0}, image = {1}, seconds = {2},  name = {3}, dateCreate = {4}), genres = {5}, url = {6}")
    @DisplayName("Song::Constructor")
    @CsvSource({
            "1, /img/song/1/cover6, 155, Mockingbird, Deiber, /uploads/deiber, 2005-04-25, 1, Rap, https://youtu.be/PElArDnvIxU?si=xZDT685WDXMBt6ng",
            "2, /img/song/2/cover2, 190, Something in the way, Adrian, /uploads/adrian, 1991-05-12, 2, Rock Rap, https://youtu.be/PElArDnvIxU?si=xZDT685WDXMBt6ng"
    })
    void songConstructorTest(Long id, String imgPath, Long seconds, String name, String artist, String artistPath, String dateCreateStr, Long idGenre, String genreName, String url) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate dateCreate = LocalDate.parse(dateCreateStr, formatter);

        List<Genre> genres = List.of(new Genre(idGenre,genreName,""));

        Song song = new Song();
        song.setId(id);
        song.setImgPath(imgPath);
        song.setSeconds(seconds);
        song.setName(name);
        song.setDateCreate(dateCreate);
        song.setGenres(genres);
        song.setArtist(artist);
        song.setArtistImgPath(artistPath);
        song.setUrl(url);

        assertAll(
                () -> assertEquals(song.getId(), id),
                () -> assertEquals(song.getImgPath(), imgPath),
                () -> assertEquals(song.getSeconds(), seconds),
                () -> assertEquals(song.getName(), name),
                () -> assertEquals(song.getDateCreate(), dateCreate),
                () -> assertEquals(song.getGenres(), genres),
                () -> assertEquals(song.getArtist(), artist),
                () -> assertEquals(song.getArtistImgPath(), artistPath),
                () -> assertEquals(song.getUrl(), url)
        );
    }
}