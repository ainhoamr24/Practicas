package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;


public interface GenreService {
    Genre findById(Long id);
    List<Genre> findAll();
    List<Genre> findByName(String name);
    List<Genre> getInPlaylist(Playlist playlist);
    List<Genre> getBySong(Song song);
    List<Genre> getGenre(Song song);
}
