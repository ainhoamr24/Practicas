package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;
import java.util.Set;

public interface SongService {
    List<Song> findByName(String name);
    List<Song> findByGenre(String genre);
    Set<Genre> getGenresBySong(Song song);
}
