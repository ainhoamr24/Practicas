package com.fpmislata.daw1.SoundE.unit.persistance.repostory;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.PlaylistRepositoryImpl;
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
public class PlaylistRepositoryImplTest {
    private final Genre GENRE = new Genre(1L,"Pop","");
    private final List<Song> songs = List.of(new Song(1L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"),null), new Song(2L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber",LocalDate.parse("2020-03-12"),List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),songs);

    private Genre genreTest;

    @Mock
    private PlaylistDao playlistDao;

    @Mock
    private PlaylistSongDao playlistSongDao;

    @InjectMocks
    private PlaylistRepositoryImpl playlistRepository;

    @Nested
    class FindById {
        @Test
        void givenExistingId_shouldReturnPlaylist() {
            when(playlistDao.findById(1L)).thenReturn(PLAYLIST);

            Playlist playlist = playlistRepository.findById(1L);

            assertEquals(PLAYLIST, playlist);
        }

        @Test
        void nonExistingId_shouldReturnNull() {
            when(playlistDao.findById(2L)).thenReturn(null);

            Playlist playlist = playlistRepository.findById(2L);

            assertNull(playlist);
        }
    }

    @Test
    void findAll() {
        when(playlistDao.findAll()).thenReturn(List.of(PLAYLIST));

        List<Playlist> playlists = playlistRepository.findAll();

        assertEquals(playlists, List.of(PLAYLIST));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_shouldReturnAPlaylistWithThatName() {
            when(playlistDao.findByName("Vowels")).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistRepository.findByName("Vowels");

            assertEquals(playlists, List.of(PLAYLIST));
        }

        @Test
        void givenPartOfAName_shouldReturnAPlaylistWithThatName() {
            when(playlistDao.findByName("Vow")).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistRepository.findByName("Vow");

            assertEquals(playlists, List.of(PLAYLIST));
        }

        @Test
        void givenNonExistingName_shouldReturnNull() {
            when(playlistDao.findByName("pepe")).thenReturn(null);

            List<Playlist> playlists = playlistRepository.findByName("pepe");

            assertNull(playlists);
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
            when(playlistSongDao.findByGenre(GENRE.getName())).thenReturn(List.of(PLAYLIST));

            List<Playlist> playlists = playlistRepository.findByGenre(GENRE.getName());

            assertEquals(playlists,List.of(PLAYLIST));
        }

        @Test
        void givenExistingGenreThatNoOneHavesIt_shoudlReturnNull() {
            when(playlistSongDao.findByGenre(genreTest.getName())).thenReturn(null);

            List<Playlist> playlists = playlistRepository.findByGenre(genreTest.getName());

            assertNull(playlists);
        }

    }
}
