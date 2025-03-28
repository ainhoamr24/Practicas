package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;

import java.util.List;

public class PlaylistRepositoryImpl implements PlaylistRepository {
    private PlaylistDao playlistDao;

    public PlaylistRepositoryImpl(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    @Override
    public Playlist findById(Long id) {
        return playlistDao.findById(id);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistDao.findAll();
    }

    @Override
    public List<Playlist> findByName(String name) {
        return playlistDao.findByName(name);
    }

    @Override
    public List<Playlist> findByGenre(String name) {
        return playlistDao.findByGenre(name);
    }
}
