package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;
import java.util.Set;

public interface PlaylistService {
    Playlist findById(Long id);
    List<Playlist> findAll();
    List<Playlist> findByName(String name);
    List<Playlist> findByGenre(Genre genre);
    List<Song> findSongsInPlaylist(Playlist playlist);
}
