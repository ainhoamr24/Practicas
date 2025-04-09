package com.fpmislata.daw1.SoundE.unit.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.impl.GenreServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.repository.GenreRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenreServiceImplTest {
    private final Song SONG1 = new Song(1L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"), null);
    private final Genre GENRE = new Genre(1L, "Pop", "");
    private final List<Song> songs = List.of(new Song(1L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"), null), new Song(2L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"), List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L, "Vowels", "/images/playlist/hunny.jpg", "HUNNY", "/images/artits/playlist", LocalDate.parse("2020-03-12"), songs);

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreServiceImpl genreService;

    @Nested
    class FindById {
        @Test
        void givenExistingId_returnGenre() {
            when(genreRepository.findById(1L)).thenReturn(GENRE);

            Genre genre = genreService.findById(1L);

            assertEquals(GENRE, genre);
        }

        @Test
        void givenNonExistingId_returnNull() {
            when(genreRepository.findById(2L)).thenReturn(null);

            Genre genre = genreService.findById(2L);

            assertNull(genre);
        }
    }

    @Test
    void findAll() {
        when(genreRepository.findAll()).thenReturn(List.of(GENRE));

        List<Genre> genres = genreService.findAll();

        assertEquals(genres, List.of(GENRE));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_returnMatchingGenres() {
            when(genreRepository.findByName("Pop")).thenReturn(List.of(GENRE));

            List<Genre> genres = genreService.findByName("Pop");

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenNonExistingName_returnNull() {
            when(genreRepository.findByName("juan")).thenReturn(null);

            List<Genre> genres = genreService.findByName("pepe");

            assertNull(genres);
        }
    }

    @Nested
    class GetGenreBySong {
        @Test
        void givenSongWithGenre_returnGenreList() {
            when(genreRepository.getGenreBySong(SONG1)).thenReturn(List.of(GENRE));

            List<Genre> genres = genreService.getGenreBySong(SONG1);

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenSongWithNoGenre_returnNull() {
            when(genreRepository.getGenreBySong(SONG1)).thenReturn(null);

            List<Genre> genres = genreService.getGenreBySong(SONG1);

            assertNull(genres);
        }
    }

    @Nested
    class GetGenreByPlaylist {
        @Test
        void givenPlaylistWithGenre_returnGenreList() {
            when(genreRepository.getGenreByPlaylist(PLAYLIST)).thenReturn(List.of(GENRE));

            List<Genre> genres = genreService.getGenreByPlaylist(PLAYLIST);

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenPlaylistWithNoGenre_returnNull() {
            when(genreRepository.getGenreByPlaylist(PLAYLIST)).thenReturn(null);

            List<Genre> genres = genreService.getGenreByPlaylist(PLAYLIST);

            assertNull(genres);
        }
    }
}
