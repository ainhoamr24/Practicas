package com.fpmislata.daw1.SoundE.persistance.dao;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

import java.util.List;

public interface PlaylistDao {
    Playlist findById(Long id);
    List<Playlist> findAll();
    List<Playlist> findByName(String name);
}
