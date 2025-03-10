package com.fpmislata.daw1.SoundE.domain.service;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.util.Set;

public interface GenreService {
    Set<Genre> getGenresByName(String name);
    Set<Song> getSongsByGenre(String genre);
}
