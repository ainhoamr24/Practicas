package com.fpmislata.daw1.SoundE.data;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;

import java.time.LocalDate;
import java.util.List;

public class GenreData {
    public static final List<Genre> GENRE_LIST = List.of(
            new Genre(1L, "Alternative Rock", "alternative_rock.jpg"),
            new Genre(2L, "Indie Rock", "indie_rock.jpg"),
            new Genre(3L, "Lo-Fi", "lofi_genre.jpg"),
            new Genre(4L, "Trip Hop", "trip_hop.jpg"),
            new Genre(5L, "Electronic", "electronic.jpg")
    );
}
