package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;

import java.util.List;

public class SongRepositoryImpl implements SongRepository {
    private final SongDao songDao;

    public SongRepositoryImpl(SongDao songDao) {
        this.songDao = songDao;
    }

    @Override
    public Song findById(Long id) {
        return songDao.findById(id);
    }

    @Override
    public List<Song> findByName(String name) {
        return songDao.findByName(name);
    }

    @Override
    public List<Song> findByGenre(Long id) {
        return songDao.findByGenre(id);
    }

    @Override
    public List<Song> getSongsByPlaylist(Long id) {
        return songDao.getSongsByPlaylist(id);
    }
}
