package com.fpmislata.daw1.SoundE.unit.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.impl.SongServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;
import org.junit.jupiter.api.BeforeEach;
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
public class SongServiceImplTest {
    private final Genre GENRE = new Genre(1L,"Pop","");
    private final Song SONG1 = new Song(1L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber",  LocalDate.parse("2020-03-12"), null);
    private final Song SONG2 = new Song(2L, "/images/songs/vowels", 230L, "Song2", "Deiber", "/uploads/deiber",  LocalDate.parse("2020-03-12"), List.of(GENRE));
    private final List<Song> SONGS = List.of(new Song(1L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"),null), new Song(2L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber",LocalDate.parse("2020-03-12"),List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),SONGS);

    private Genre genreTest;

    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongServiceImpl songService;

    @Nested
    class FindById {
        @Test
        void givenExistingId_shouldReturnSong() {
            when(songRepository.findById(1L)).thenReturn(SONG1);

            Song song = songService.findById(1L);

            assertEquals(SONG1, song);
        }

        @Test
        void nonExistingId_shouldReturnNull() {
            when(songRepository.findById(2L)).thenReturn(null);

            Song song = songService.findById(2L);


            assertNull(song);
        }
    }

    @Test
    void findAll() {
        when(songRepository.findAll()).thenReturn(List.of(SONG1));

        List<Song> songs = songService.findAll();

        assertEquals(songs, List.of(SONG1));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_shouldReturnASongWithThatName() {
            when(songRepository.findByName("Song1")).thenReturn(List.of(SONG1));

            List<Song> songs = songService.findByName("Song1");

            assertEquals(songs, List.of(SONG1));
        }

        @Test
        void givenPartOfAName_shouldReturnASongWithThatName() {
            when(songRepository.findByName("Song2")).thenReturn(List.of(SONG2));

            List<Song> songs = songService.findByName("Song2");

            assertEquals(songs, List.of(SONG2));
        }

        @Test
        void givenNonExistingName_shouldReturnNull() {
            when(songRepository.findByName("pepe")).thenReturn(null);

            List<Song> songs = songService.findByName("pepe");


            assertNull(songs);
        }
    }

    @Nested
    class FindByGenre {

        @BeforeEach
        void setup() {
            genreTest = new Genre(2L,"RAP","");
        }

        @Test
        void givenAExistingGenre_shouldReturnASongThatHaveIt() {
            when(songRepository.findByGenre(GENRE.getId())).thenReturn(List.of(SONG1));

            List<Song> songs = songService.findByGenre(GENRE);

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingGenreThatNoOneHavesIt_shouldReturnNull() {
            when(songRepository.findByGenre(genreTest.getId())).thenReturn(null);

            List<Song> songs = songService.findByGenre(genreTest);


            assertNull(songs);
        }
    }

    @Nested
    class GetSongsByPlaylist {

        @Test
        void givenAExistingPlaylist_shouldReturnASongThatHaveIt() {
            when(songRepository.getSongsByPlaylist(PLAYLIST.getId())).thenReturn(List.of(SONG1));

            List<Song> songs = songService.getSongsByPlaylist(PLAYLIST);

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingPlaylistThatNoOneHavesIt_shouldReturnNull() {
            when(songRepository.getSongsByPlaylist(PLAYLIST.getId())).thenReturn(null);

            assertNull(songService.getSongsByPlaylist(PLAYLIST));
        }
    }
}
