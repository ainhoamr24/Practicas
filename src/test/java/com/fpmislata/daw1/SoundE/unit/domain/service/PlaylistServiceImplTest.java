package com.fpmislata.daw1.SoundE.unit.domain.service;

import com.fpmislata.daw1.SoundE.data.GenreData;
import com.fpmislata.daw1.SoundE.data.PlaylistData;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.impl.PlaylistServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlaylistServiceImplTest {
    public final List<Playlist> PLAYLIST_LIST = PlaylistData.PLAYLIST_LIST;
    public final List<Genre> GENRE_LIST = GenreData.GENRE_LIST;

    private Genre genreTest;

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistServiceImpl playlistService;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnPlaylist() {
            when(playlistRepository.findById(1L)).thenReturn(PLAYLIST_LIST.get(0));

            Playlist result = playlistService.findById(1L);

            assertEquals(PLAYLIST_LIST.get(0), result);
        }

        @Test
        void findByDifferentId_shouldReturnDifferentPlaylist() {
            when(playlistRepository.findById(2L)).thenReturn(PLAYLIST_LIST.get(1));

            Playlist result = playlistService.findById(2L);

            assertEquals(PLAYLIST_LIST.get(1), result);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            when(playlistRepository.findById(7L)).thenReturn(null);

            Playlist result = playlistService.findById(7L);

            assertNull(result);
        }
    }

    @Test
    void findAll_shouldReturnAllPlaylists() {
        when(playlistRepository.findAll()).thenReturn(PLAYLIST_LIST);

        List<Playlist> result = playlistService.findAll();

        assertEquals(result, PLAYLIST_LIST);
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingPlaylist() {
            when(playlistRepository.findByName("Gorillaz")).thenReturn(List.of(PLAYLIST_LIST.get(0)));
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0));

            List<Playlist> result = playlistService.findByName("Gorillaz");

            assertEquals(expectedList, result);
        }

        @Test
        void findByName_shouldReturnMultipleMatchingPlaylists() {
            when(playlistRepository.findByName("i")).thenReturn(List.of(PLAYLIST_LIST.get(0), PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(3)));
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0), PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(3));

            List<Playlist> result = playlistService.findByName("i");

            assertEquals(expectedList, result);
        }

        @Test
        void givenNonExistingName_shouldReturnEmptyList() {
            when(playlistRepository.findByName("pepe")).thenReturn(List.of());

            List<Playlist> result = playlistService.findByName("pepe");

            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class FindByGenre {

        @BeforeEach
        void setup() {
            genreTest = new Genre(7L,"RAP","");
        }

        @Test
        void findByGenre_shouldReturnPlaylistWithIt() {
            when(playlistRepository.findByGenre(GENRE_LIST.get(0).getName())).thenReturn(List.of(PLAYLIST_LIST.get(0)));
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(0));

            List<Playlist> result = playlistService.findByGenre(GENRE_LIST.get(0));

            assertEquals(expectedList, result);
        }

        @Test
        void findByGenre_shouldReturnPlaylistsWithIt() {
            when(playlistRepository.findByGenre(GENRE_LIST.get(1).getName())).thenReturn(List.of(PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(2)));
            List<Playlist> expectedList = List.of(PLAYLIST_LIST.get(1), PLAYLIST_LIST.get(2));

            List<Playlist> result = playlistService.findByGenre(GENRE_LIST.get(1));

            assertEquals(result,expectedList);
        }

        @Test
        void findByNonExistentGenre_shouldReturnEmptyList() {
            when(playlistRepository.findByGenre(genreTest.getName())).thenReturn(List.of());

            List<Playlist> playlists = playlistService.findByGenre(genreTest);

            assertTrue(playlists.isEmpty());
        }

    }
}
