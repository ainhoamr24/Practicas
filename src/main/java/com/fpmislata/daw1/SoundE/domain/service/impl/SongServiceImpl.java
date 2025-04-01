package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.SongService;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;
import com.fpmislata.daw1.SoundE.persistance.repository.SongRepository;

import java.util.List;

public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findByName(String name) {
        return songRepository.findByName(name);
    }

    @Override
    public List<Song> findByGenre(Genre genre) {
        return songRepository.findByGenre(genre.getName());
    }
}
