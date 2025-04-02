package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;

import java.util.List;

public class PlaylistRepositoryImpl implements PlaylistRepository {
    private final PlaylistDao playlistDao;
    private final PlaylistSongDao playlistSongDao;

    public PlaylistRepositoryImpl(PlaylistDao playlistDao, PlaylistSongDao playlistSongDao) {
        this.playlistDao = playlistDao;
        this.playlistSongDao = playlistSongDao;
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
        return playlistSongDao.findByGenre(name);
    }
}
