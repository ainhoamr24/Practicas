package com.fpmislata.daw1.SoundE.unit.persistance.dao.jdbc;

import com.fpmislata.daw1.SoundE.data.GenreData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.GenreDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.GenreDaoJdbc;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreDaoJdbcTest extends JdbcTest {
    private final GenreDao genreDao = new GenreDaoJdbc();
    public final List<Genre> expectedGenreList = GenreData.GENRE_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnGenre() {
            Genre result = genreDao.findById(1L);
            assertEquals(expectedGenreList.get(0), result);
        }

        @Test
        void findByDifferentId_shouldReturnDifferentGenre() {
            Genre result = genreDao.findById(2L);
            assertEquals(expectedGenreList.get(1), result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Genre result = genreDao.findById(8L);
            assertNull(result);
        }
    }

    @Nested
    class FindAll {
        @Test
        void findAll_shouldReturnAllGenres() {
            List<Genre> result = genreDao.findAll();
            assertEquals(expectedGenreList, result);
        }
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingGenres() {
            List<Genre> result = genreDao.findByName("Rock");
            List<Genre> expectedList = List.of(expectedGenreList.get(0), expectedGenreList.get(1));

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingGenres() {
            List<Genre> result = genreDao.findByName("i");
            List<Genre> expectedList = List.of(
                    expectedGenreList.get(0),
                    expectedGenreList.get(1),
                    expectedGenreList.get(2),
                    expectedGenreList.get(3),
                    expectedGenreList.get(4)
            );

            assertEquals(expectedList, result);
        }

        @Test
        void findByNonExistentName_shouldReturnEmptyList() {
            List<Genre> result = genreDao.findByName("Metal");
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class GetGenreBySong {
        @Test
        void getGenreBySong_shouldReturnGenres() {
            Song song = new Song(1L, "gorillaz.jpg", 270L, "Re-Hash", "Gorillaz", "gorillaz.jpg", LocalDate.parse("2025-05-06"), null, "https://www.youtube.com/watch?v=Z3aC2SptDag");
            List<Genre> result = genreDao.getGenreBySong(song);
            List<Genre> expectedList = List.of(expectedGenreList.get(0), expectedGenreList.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void getGenreBySong_shouldReturnDifferentGenres() {
            Song song = new Song(7L, "lofi.jpg", 185L, "Midnight Study", "Lo-Fi Beats", "lofi.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/1tUPFQ54gqc?si=QLu9f4kxjhKBbXvt");
            List<Genre> result = genreDao.getGenreBySong(song);
            List<Genre> expectedList = List.of(expectedGenreList.get(2), expectedGenreList.get(4));

            assertEquals(expectedList, result);
        }
    }

    @Nested
    class GetGenreByPlaylist {
        @Test
        void getGenreByPlaylist_shouldReturnGenres() {
            Playlist playlist = new Playlist(1L, "Gorillaz", "gorillaz.jpg", "Gorillaz", "gorillaz.jpg", LocalDate.parse("2025-05-06"),null);

            List<Genre> result = genreDao.getGenreByPlaylist(playlist);
            List<Genre> expectedList = List.of(expectedGenreList.get(0), expectedGenreList.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void getGenreByPlaylist_shouldReturnDifferentGenres() {
            Playlist playlist = new Playlist(4L, "Lo-Fi Beats", "lofi.jpg", "Lo-Fi Beats", "lofi.jpg", LocalDate.parse("2025-05-06"),null);

            List<Genre> result = genreDao.getGenreByPlaylist(playlist);
            List<Genre> expectedList = List.of(expectedGenreList.get(2), expectedGenreList.get(4));

            assertEquals(expectedList, result);
        }
    }
}