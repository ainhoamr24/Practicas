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
            when(songService.findById(1L)).thenReturn(SONG1);

            Song song = songService.findById(1L);

            assertEquals(SONG1, song);
        }

        @Test
        void nonExistingId_shouldReturnNull() {
            when(songService.findById(2L)).thenReturn(null);

            assertNull(songService.findById(2L));
        }
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_shouldReturnASongWithThatName() {
            when(songService.findByName("Song1")).thenReturn(List.of(SONG1));

            List<Song> songs = songService.findByName("Song1");

            assertEquals(songs, List.of(SONG1));
        }

        @Test
        void givenPartOfAName_shouldReturnASongWithThatName() {
            when(songService.findByName("Song2")).thenReturn(List.of(SONG2));

            List<Song> songs = songService.findByName("Song2");

            assertEquals(songs, List.of(SONG2));
        }

        @Test
        void givenNonExistingName_shouldReturnNull() {
            when(songService.findByName("pepe")).thenReturn(null);

            assertNull(songService.findByName("pepe"));
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
            when(songService.findByGenre(GENRE)).thenReturn(List.of(SONG1));

            List<Song> songs = songService.findByGenre(GENRE);

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingGenreThatNoOneHavesIt_shouldReturnNull() {
            when(songService.findByGenre(genreTest)).thenReturn(null);

            assertNull(songService.findByGenre(genreTest));
        }
    }

    @Nested
    class GetSongsByPlaylist {

        @Test
        void givenAExistingPlaylist_shouldReturnASongThatHaveIt() {
            when(songService.getSongsByPlaylist(PLAYLIST)).thenReturn(List.of(SONG1));

            List<Song> songs = songService.getSongsByPlaylist(PLAYLIST);

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingPlaylistThatNoOneHavesIt_shouldReturnNull() {
            when(songService.getSongsByPlaylist(PLAYLIST)).thenReturn(null);

            assertNull(songService.getSongsByPlaylist(PLAYLIST));
        }
    }
}
