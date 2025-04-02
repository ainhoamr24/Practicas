package com.fpmislata.daw1.SoundE.persistance.repository.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.GenreDao;
import com.fpmislata.daw1.SoundE.persistance.repository.GenreRepository;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {
    private final GenreDao genreDao;
    public GenreRepositoryImpl(GenreDao genreDao){
        this.genreDao = genreDao;
    }

    @Override
    public Genre findById(Long id) {
        return genreDao.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public List<Genre> findByName(String name) {
        return genreDao.findByName(name);
    }

    @Override
    public List<Genre> getGenreBySong(Song song) {
        return genreDao.getGenreBySong(song);
    }

    @Override
    public List<Genre> getGenreByPlaylist(Playlist playlist) {
        return genreDao.getGenreByPlaylist(playlist);
    }
}
