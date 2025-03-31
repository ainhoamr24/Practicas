package com.fpmislata.daw1.SoundE.persistance.dao;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;

public interface SongDao {
    Song findById(Long id);
    List<Song> findByName(String name);
    List<Song> findByGenre(Genre genre);
    List<Song> getGenre(Genre genre);
    List<Song> getInPlaylist(Playlist playlist);
}
