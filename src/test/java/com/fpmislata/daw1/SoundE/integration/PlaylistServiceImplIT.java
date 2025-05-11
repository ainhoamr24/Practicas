package com.fpmislata.daw1.SoundE.integration;

import com.fpmislata.daw1.SoundE.data.GenreData;
import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.service.PlaylistService;
import com.fpmislata.daw1.SoundE.domain.service.impl.PlaylistServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.PlaylistSongDaoJdbc;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.PlaylistRepositoryImpl;
import com.fpmislata.daw1.SoundE.utils.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistServiceImplIT extends JdbcTest {
    private final PlaylistService playlistService = new PlaylistServiceImpl(
            new PlaylistRepositoryImpl(
                    new PlaylistDaoJdbc(), new PlaylistSongDaoJdbc()
            )
    );
    public final List<Playlist> PLAYLIST_LIST = PlaylistData.PLAYLIST_LIST;
    public final List<Genre> GENRE_LIST = GenreData.GENRE_LIST;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnPlaylist() {
            Playlist expected = PLAYLIST_LIST.get(0);

            Playlist result = playlistService.findById(1L);

            assertEquals(expected, result);

        }

        @Test
        void findByDifferentId_shouldReturnDifferentPlaylist() {
            Playlist expected = PLAYLIST_LIST.get(1);

            Playlist result = playlistService.findById(2L);

            assertEquals(expected, result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            Playlist result = playlistService.findById(7L);

            assertNull(result);
        }
    }

    @Test
    void findAll_shouldReturnAllPlaylists() {
        List<Playlist> result = playlistService.findAll();

        assertEquals(result, PLAYLIST_LIST);
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingPlaylist() {
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0));

            List<Playlist> result = playlistService.findByName("Gorillaz");

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingPlaylists() {
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0), PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(3));

            List<Playlist> result = playlistService.findByName("i");

            assertEquals(expectedList, result);
        }

        @Test
        void givenNonExistingName_shouldReturnEmptyList() {
            List<Playlist> result = playlistService.findByName("pepe");

            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByGenre {
        @Test
        void givenGenre_shouldReturnListOfPlaylistWithIt() {
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0));

            List<Playlist> result = playlistService.findByGenre(GENRE_LIST.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void givenGenre_shouldReturnListOfPlaylistsWithIt(){
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(2));

            List<Playlist> result = playlistService.findByGenre(GENRE_LIST.get(1));

            assertEquals(expectedList, result);
        }

        @Test
        void givenNonExistentGenre_shouldReturnEmptyList() {
            List<Playlist> result = playlistService.findByGenre(new Genre(9L,"Inventado",null));

            assertTrue(result.isEmpty());
        }

    }

}
