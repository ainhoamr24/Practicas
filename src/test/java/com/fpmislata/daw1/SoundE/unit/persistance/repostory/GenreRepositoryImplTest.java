package com.fpmislata.daw1.SoundE.unit.persistance.repostory;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.GenreDao;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.GenreRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GenreRepositoryImplTest {
    private final Song SONG1 = new Song(1L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber",  LocalDate.parse("2020-03-12"), null);
    private final Genre GENRE = new Genre(1L,"Pop","");
    private final List<Song> songs = List.of(new Song(1L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"),null), new Song(2L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber",LocalDate.parse("2020-03-12"),List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),songs);

    @Mock
    private GenreDao genreDao;

    @InjectMocks
    private GenreRepositoryImpl genreRepository;

    @Nested
    class FindById {
        @Test
        void givenExistingId_returnGenre() {
            when(genreDao.findById(1L)).thenReturn(GENRE);

            Genre genre = genreRepository.findById(1L);

            assertEquals(GENRE, genre);
        }

        @Test
        void givenNonExistingId_returnNull() {
            when(genreDao.findById(2L)).thenReturn(null);

            assertNull(genreRepository.findById(2L));
        }
    }

    @Test
    void findAll() {
        when(genreRepository.findAll()).thenReturn(List.of(GENRE));

        List<Genre> genres = genreRepository.findAll();

        assertEquals(genres, List.of(GENRE));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_returnMatchingGenres() {
            when(genreRepository.findByName("Pop")).thenReturn(List.of(GENRE));

            List<Genre> genres = genreRepository.findByName("Pop");

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenNonExistingName_returnNull() {
            when(genreRepository.findByName("juan")).thenReturn(null);

            assertNull(genreRepository.findByName("juan"));
        }
    }

    @Nested
    class GetGenreBySong {
        @Test
        void givenSongWithGenre_returnGenreList() {
            when(genreRepository.getGenreBySong(SONG1)).thenReturn(List.of(GENRE));

            List<Genre> genres = genreRepository.getGenreBySong(SONG1);

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenSongWithNoGenre_returnNull() {
            when(genreRepository.getGenreBySong(SONG1)).thenReturn(null);

            assertNull(genreRepository.getGenreBySong(SONG1));
        }
    }

    @Nested
    class GetGenreByPlaylist {
        @Test
        void givenPlaylistWithGenre_returnGenreList() {
            when(genreRepository.getGenreByPlaylist(PLAYLIST)).thenReturn(List.of(GENRE));

            List<Genre> genres = genreRepository.getGenreByPlaylist(PLAYLIST);

            assertEquals(genres, List.of(GENRE));
        }

        @Test
        void givenPlaylistWithNoGenre_returnNull() {
            when(genreRepository.getGenreByPlaylist(PLAYLIST)).thenReturn(null);

            assertNull(genreRepository.getGenreByPlaylist(PLAYLIST));
        }
    }
}
