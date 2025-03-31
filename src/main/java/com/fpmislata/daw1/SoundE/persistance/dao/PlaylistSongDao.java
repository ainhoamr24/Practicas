package com.fpmislata.daw1.SoundE.persistance.dao;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

import java.util.List;

public interface PlaylistSongDao {
    List<Playlist> findByGenre(String name);
    Playlist getPlaylistWithSongs(Long id);
}
