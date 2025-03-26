package com.fpmislata.daw1.SoundE.persistance.repository;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;

public interface SongRepository {
    Song findById(Long id);
    List<Song> findByName(String name);
    List<Song> findByGenre(String genre);
    List<Song> getByGenre(String genre);
    List<Song> getInPlaylist(Playlist playlist);
}
