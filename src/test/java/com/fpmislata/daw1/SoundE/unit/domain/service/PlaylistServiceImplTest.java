package com.fpmislata.daw1.SoundE.unit.domain.service;

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
    private final Genre GENRE = new Genre(1L,"Pop","");
    private final List<Song> songs = List.of(new Song(1L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"),null), new Song(2L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber",LocalDate.parse("2020-03-12"),List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),songs);
    private final List<Playlist> playlistList = PlaylistData.PLAYLIST_LIST;

    private Genre genreTest;

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistServiceImpl playlistService;

    @Nested
    class FindById {
        @Test
        void findById_shouldReturnPlaylist() {
            when(playlistRepository.findById(1L)).thenReturn(PLAYLIST);

            Playlist playlist = playlistService.findById(1L);

            assertEquals(PLAYLIST, playlist);
        }

        @Test
        void findByNonExistentId_shouldReturnNull() {
            when(playlistRepository.findById(2L)).thenReturn(null);

            Playlist playlist = playlistService.findById(2L);

            assertNull(playlist);
        }
    }

    @Test
    void findAll_shouldReturnAllPlaylists() {
        when(playlistRepository.findAll()).thenReturn(List.of(PLAYLIST));

        List<Playlist> playlists = playlistService.findAll();

        assertEquals(playlists, List.of(PLAYLIST));
    }

    @Nested
    class FindByName {
        @Test
        void findByName_shouldReturnMatchingPlaylist() {
            when(playlistRepository.findByName("Vowels")).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistService.findByName("Vowels");

            assertEquals(playlists, List.of(PLAYLIST));
        }

        @Test
        void findByName_shouldReturnMultipleMatchingPlaylists() {
            when(playlistRepository.findByName("i")).thenReturn(List.of(playlistList.get(0), playlistList.get(1), playlistList.get(3)));

            List<Playlist> result = playlistService.findByName("i");
            List<Playlist> expectedList = List.of(playlistList.get(0), playlistList.get(1), playlistList.get(3));

            assertEquals(expectedList, result);
        }

        @Test
        void givenNonExistingName_shouldReturnEmptyList() {
            when(playlistRepository.findByName("pepe")).thenReturn(List.of());

            List<Playlist> playlists = playlistService.findByName("pepe");

            assertTrue(playlists.isEmpty());
        }
    }

    @Nested
    class FindByGenre {

        @BeforeEach
        void setup() {
            genreTest = new Genre(2L,"RAP","");
        }

        @Test
        void findByGenre_shouldReturnPlaylistWithIt() {
            when(playlistRepository.findByGenre(GENRE.getName())).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistService.findByGenre(GENRE);

            assertEquals(playlists,List.of(PLAYLIST));
        }

        @Test
        void findByNonExistentGenre_shouldReturnEmptyList() {
            when(playlistRepository.findByGenre(genreTest.getName())).thenReturn(List.of());

            List<Playlist> playlists = playlistService.findByGenre(genreTest);

            assertTrue(playlists.isEmpty());
        }

    }
}
