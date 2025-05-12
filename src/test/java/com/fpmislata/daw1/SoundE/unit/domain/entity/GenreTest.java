package com.fpmislata.daw1.SoundE.unit.domain.entity;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreTest {
    @ParameterizedTest(name = "(id = {0}, name = {1}, image = {2})")
    @DisplayName("Genre::Constructor")
    @CsvSource({
            "1, Rap, /img/song/1/cover6",
            "2, Rock, /img/song/2/cover2"
    })
    void genreConstructorTest(Long id, String name, String imgPath) {

        Genre genre = new Genre();
        genre.setId(id);
        genre.setName(name);
        genre.setImgPath(imgPath);

        assertAll(
                () -> assertEquals(genre.getId(), id),
                () -> assertEquals(genre.getName(), name),
                () -> assertEquals(genre.getImgPath(), imgPath)
        );
    }
}
