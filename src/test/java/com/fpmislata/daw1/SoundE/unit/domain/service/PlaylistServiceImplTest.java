package com.fpmislata.daw1.SoundE.unit.domain.service;

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

    private Genre genreTest;

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistServiceImpl playlistService;

    @Nested
    class FindById {
        @Test
        void givenExistingId_shouldReturnPlaylist() {
            when(playlistRepository.findById(1L)).thenReturn(PLAYLIST);

            Playlist playlist = playlistService.findById(1L);

            assertEquals(PLAYLIST, playlist);
        }

        @Test
        void nonExistingId_shouldReturnNull() {
            when(playlistRepository.findById(2L)).thenReturn(null);

            assertNull(playlistService.findById(2L));
        }
    }

    @Test
    void findAll() {
        when(playlistService.findAll()).thenReturn(List.of(PLAYLIST));

        List<Playlist> playlists = playlistService.findAll();

        assertEquals(playlists, List.of(PLAYLIST));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_shouldReturnAPlaylistWithThatName() {
            when(playlistService.findByName("Vowels")).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistService.findByName("Vowels");

            assertEquals(playlists, List.of(PLAYLIST));
        }

        @Test
        void givenPartOfAName_shouldReturnAPlaylistWithThatName() {
            when(playlistService.findByName("Vow")).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistService.findByName("Vow");

            assertEquals(playlists, List.of(PLAYLIST));
        }

        @Test
        void givenNonExistingName_shouldReturnNull() {
            when(playlistService.findByName("pepe")).thenReturn(null);

            assertNull(playlistService.findByName("pepe"));
        }
    }

    @Nested
    class FindByGenre {

        @BeforeEach
        void setup() {
            genreTest = new Genre(2L,"RAP","");
        }

        @Test
        void givenAExistingGenre_shoudlReturnAPlaylistThatHaveIt() {
            when(playlistService.findByGenre(GENRE)).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistService.findByGenre(GENRE);

            assertEquals(playlists,List.of(PLAYLIST));
        }

        @Test
        void givenExistingGenreThatNoOneHavesIt_shoudlReturnNull() {
            when(playlistService.findByGenre(genreTest)).thenReturn(null);

            assertNull(playlistService.findByGenre(genreTest));
        }

    }

    @Test
    void givenPlaylistWitAttributeSongsVoid_shoudlReturnPlaylistWithSongs() {
        Playlist playlistTest = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),null);
        when(playlistService.getPlaylistWithSongs(playlistTest)).thenReturn(PLAYLIST);

        Playlist playlist = playlistService.getPlaylistWithSongs(playlistTest);

        assertEquals(playlist, PLAYLIST);
    }
}
