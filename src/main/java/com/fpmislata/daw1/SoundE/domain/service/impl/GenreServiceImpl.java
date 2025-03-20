package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.GenreService;

import java.util.List;

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
    public List<Song> getSongsByGenre(String genre) {
        return genreRepository.getSongsByGenre(genre);
    }
}
