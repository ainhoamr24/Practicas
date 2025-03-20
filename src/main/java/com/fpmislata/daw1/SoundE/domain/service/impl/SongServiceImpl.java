package com.fpmislata.daw1.SoundE.domain.service.impl;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.SongService;

import java.util.List;

public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song findById(Long id) throws SongException{
        Song song = songRepository.findById(id);
        if(song == null)
            throw new SongException("La cancion con id: " + id + " no existe");
        return song;
    }

    @Override
    public List<Song> findByName(String name) throws SongException {
        List<Song> songs = songRepository.findByName(name);
        if(songs.isEmpty())
            throw new SongException("No se ha encontrado ninguna cancion con el nombre: " + name);
        return songs;
    }

    @Override
    public List<Song> findByGenre(String genre) throws SongException {
        List<Song> songs = songRepository.findByGenre(genre);
        if(songs.isEmpty())
            throw new SongException("No se ha encontrado ninguna canción con el genero: " + genre);
        return songs;
    }

    @Override
    public List<Genre> getGenresBySong(Song song) throws SongException {
        List<Genre> genres = songRepository.getGenresBySong;
        if(genres.isEmpty())
            throw new SongException("La cancion: " + song.getName() + "no contiene ningun genero");
        return genres;
    }
}
