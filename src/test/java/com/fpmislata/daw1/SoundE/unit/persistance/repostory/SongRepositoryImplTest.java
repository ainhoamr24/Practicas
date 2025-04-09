package com.fpmislata.daw1.SoundE.unit.persistance.repostory;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.impl.SongServiceImpl;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.impl.SongRepositoryImpl;
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
public class SongRepositoryImplTest {
    private final Genre GENRE = new Genre(1L,"Pop","");
    private final Song SONG1 = new Song(1L, "/images/songs/vowels", 230L, "Song1", "Deiber", "/uploads/deiber",  LocalDate.parse("2020-03-12"), null);
    private final Song SONG2 = new Song(2L, "/images/songs/vowels", 230L, "Song2", "Deiber", "/uploads/deiber",  LocalDate.parse("2020-03-12"), List.of(GENRE));
    private final List<Song> SONGS = List.of(new Song(1L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber", LocalDate.parse("2020-03-12"),null), new Song(2L,"/images/songs/vowels",230L,"Song1", "Deiber", "/uploads/deiber",LocalDate.parse("2020-03-12"),List.of(GENRE)));
    private final Playlist PLAYLIST = new Playlist(1L,"Vowels","/images/playlist/hunny.jpg","HUNNY","/images/artits/playlist",LocalDate.parse("2020-03-12"),SONGS);

    private Genre genreTest;

    @Mock
    private SongDao songDao;

    @InjectMocks
    private SongRepositoryImpl songRepository;

    @Nested
    class FindById {
        @Test
        void givenExistingId_shouldReturnSong() {
            when(songDao.findById(1L)).thenReturn(SONG1);

            Song song = songRepository.findById(1L);

            assertEquals(SONG1, song);
        }

        @Test
        void nonExistingId_shouldReturnNull() {
            when(songDao.findById(2L)).thenReturn(null);

            Song song = songRepository.findById(2L);

            assertNull(song);
        }
    }

    @Test
    void findAll() {
        when(songDao.findAll()).thenReturn(List.of(SONG1));

        List<Song> songs = songRepository.findAll();

        assertEquals(songs, List.of(SONG1));
    }

    @Nested
    class FindByName {
        @Test
        void givenExistingName_shouldReturnASongWithThatName() {
            when(songDao.findByName("Song1")).thenReturn(List.of(SONG1));

            List<Song> songs = songRepository.findByName("Song1");

            assertEquals(songs, List.of(SONG1));
        }

        @Test
        void givenPartOfAName_shouldReturnASongWithThatName() {
            when(songDao.findByName("Song2")).thenReturn(List.of(SONG2));

            List<Song> songs = songRepository.findByName("Song2");

            assertEquals(songs, List.of(SONG2));
        }

        @Test
        void givenNonExistingName_shouldReturnNull() {
            when(songDao.findByName("pepe")).thenReturn(null);

            List<Song> songs = songRepository.findByName("pepe");

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
            when(songDao.findByGenre(GENRE.getId())).thenReturn(List.of(SONG1));

            List<Song> songs = songRepository.findByGenre(GENRE.getId());

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingGenreThatNoOneHavesIt_shouldReturnNull() {
            when(songDao.findByGenre(genreTest.getId())).thenReturn(null);

            List<Song> songs = songRepository.findByGenre(GENRE.getId());

            assertNull(songs);
        }
    }

    @Nested
    class GetSongsByPlaylist {

        @Test
        void givenAExistingPlaylist_shouldReturnASongThatHaveIt() {
            when(songDao.getSongsByPlaylist(PLAYLIST.getId())).thenReturn(List.of(SONG1));

            List<Song> songs = songRepository.getSongsByPlaylist(PLAYLIST.getId());

            assertEquals(songs,List.of(SONG1));
        }

        @Test
        void givenExistingPlaylistThatNoOneHavesIt_shouldReturnNull() {
            when(songDao.getSongsByPlaylist(PLAYLIST.getId())).thenReturn(null);

            List<Song> songs = songRepository.getSongsByPlaylist(PLAYLIST.getId());

            assertNull(songs);
        }
    }
}
