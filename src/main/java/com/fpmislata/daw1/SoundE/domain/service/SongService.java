package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;

public interface SongService {
    Song findById(Long id);
    List<Song> findByName(String name);
    List<Song> findByGenre(Genre genre);
    List<Song> getSongsByPlaylist(Playlist playlist);
}
