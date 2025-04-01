package com.fpmislata.daw1.SoundE.persistance.dao;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.List;

public interface GenreDao {
    Genre findById(Long id);
    List<Genre> findAll();
    List<Genre> findByName(String name);
}
