package com.fpmislata.daw1.SoundE.integration;

import com.fpmislata.daw1.SoundE.data.GenreData;
import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.data.SongData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.GenreService;
import com.fpmislata.daw1.SoundE.domain.service.impl.GenreServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.GenreDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.GenreRepositoryImpl;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreServiceImplIT extends JdbcTest {
    private final GenreService genreService = new GenreServiceImpl(
            new GenreRepositoryImpl(new GenreDaoJdbc())
    );
    public final List<Genre> GENRE_LIST = GenreData.GENRE_LIST;
    public final List<Song> SONG_LIST = SongData.SONG_LIST;
    public final List<Playlist> PLAYLIST_LIST = PlaylistData.PLAYLIST_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnGenre() {
            Genre expected = GENRE_LIST.get(0);

            Genre result = genreService.findById(1L);

            assertEquals(expected, result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Genre result = genreService.findById(99L);

            assertNull(result);
        }
    }

    @Test
    void findAll_shouldReturnAllGenres() {
        List<Genre> result = genreService.findAll();

        assertEquals(GENRE_LIST, result);
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingGenres() {
            List<Genre> expected = List.of(GENRE_LIST.get(0));

            List<Genre> result = genreService.findByName("Alternative Rock");

            assertEquals(expected, result);
        }

        @Test
        void findByNonExistentName_shouldReturnEmptyList() {
            List<Genre> result = genreService.findByName("No existe");

            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class GetGenreBySong {
        @Test
        void getGenreBySong_shouldReturnGenres() {
            Song song = SONG_LIST.get(0);
            List<Genre> expected = List.of(GENRE_LIST.get(0), GENRE_LIST.get(3));

            List<Genre> result = genreService.getGenreBySong(song);

            assertEquals(expected, result);
        }

        @Test
        void getGenreBySongWithoutGenres_shouldReturnEmptyList() {
            Song song = new Song(99L, "test.jpg", 180L, "Test Song", "Test Artist", "test.jpg", null, null);

            List<Genre> result = genreService.getGenreBySong(song);

            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class GetGenreByPlaylist {
        @Test
        void getGenreByPlaylist_shouldReturnGenres() {
            Playlist playlist = PLAYLIST_LIST.get(0);
            List<Genre> expected = List.of(GENRE_LIST.get(0), GENRE_LIST.get(3));

            List<Genre> result = genreService.getGenreByPlaylist(playlist);

            assertEquals(expected, result);
        }

        @Test
        void getGenreByPlaylistWithoutGenres_shouldReturnEmptyList() {
            Playlist playlist = new Playlist(9L, "prueba", "prueba.jpg", "prueba", "prueba.jpg", null, null);

            List<Genre> result = genreService.getGenreByPlaylist(playlist);

            assertTrue(result.isEmpty());
        }
    }
}