package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.GenreService;
import com.fpmislata.daw1.SoundE.persistance.repository.GenreRepository;

import java.util.List;
import java.util.Set;

public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public List<Genre> getGenreBySong(Song song) {
        return genreRepository.getGenreBySong(song);
    }

    @Override
    public List<Genre> getGenreByPlaylist(Playlist playlist) {
        return genreRepository.getGenreByPlaylist(playlist);
    }
}
