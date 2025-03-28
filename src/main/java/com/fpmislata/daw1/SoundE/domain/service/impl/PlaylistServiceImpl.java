package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.PlaylistService;
import com.fpmislata.daw1.SoundE.persistance.repository.PlaylistRepository;

import java.util.List;
import java.util.Set;

public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Playlist findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> findByName(String name) {
        return playlistRepository.findByName(name);
    }

    @Override
    public List<Playlist> findByGenre(Genre genre) {
        return playlistRepository.findByGenre(genre.getName());
    }

    @Override
    public Playlist getPlaylistWithSongs(Playlist playlist) {
        return playlistRepository.getPlaylistWithSongs(playlist.getId());
    }
}