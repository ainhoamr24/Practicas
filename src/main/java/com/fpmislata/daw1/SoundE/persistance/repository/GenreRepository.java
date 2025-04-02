package com.fpmislata.daw1.SoundE.persistance.repository;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;

public interface GenreRepository {
    Genre findById(Long id);
    List<Genre> findAll();
    List<Genre> findByName(String name);
    List<Genre> getGenreBySong(Song song);
    List<Genre> getGenreByPlaylist(Playlist playlist);
}
