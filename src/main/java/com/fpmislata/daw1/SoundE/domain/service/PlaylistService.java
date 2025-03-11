package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;
import java.util.Set;

public interface PlaylistService {
    Playlist findPlaylistById(Long id);
    List<Playlist> findByName(String name);
    Set<Playlist> findByGenre(String genre);
    Set<Song> getSongsInPlaylist();
    Set<Genre> getGenresInPlaylist();
}
