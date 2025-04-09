package com.fpmislata.daw1.SoundE.controller;

import com.fpmislata.daw1.SoundE.common.container.GenreIoc;
import com.fpmislata.daw1.SoundE.common.container.PlaylistIoc;
import com.fpmislata.daw1.SoundE.common.container.SongIoc;
import com.fpmislata.daw1.SoundE.controller.components.MediaItem;
import com.fpmislata.daw1.SoundE.controller.components.PlaylistMediaItemMapper;
import com.fpmislata.daw1.SoundE.controller.components.SongMediaItemMapper;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.service.GenreService;
import com.fpmislata.daw1.SoundE.domain.service.PlaylistService;
import com.fpmislata.daw1.SoundE.domain.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final PlaylistService playlistService;
    private final SongService songService;
    private final GenreService genreService;

    public MainController() {
        this.playlistService = PlaylistIoc.createService();
        this.songService = SongIoc.createService();
        this.genreService = GenreIoc.createService();
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String index(Model model) {

        // Muestro 4 canciones y 4 listas aleatorias.

        List<MediaItem> recentsPlaylists = playlistService.findAll().stream().map(PlaylistMediaItemMapper::map).collect(Collectors.collectingAndThen(Collectors.toList(),
                collected -> {
                    Collections.shuffle(collected);
                    return collected.stream();
                })).limit(4).toList();

        List<MediaItem> recentsSongs = songService.findAll().stream().map(SongMediaItemMapper::map).collect(Collectors.collectingAndThen(Collectors.toList(),
                collected -> {
                    Collections.shuffle(collected);
                    return collected.stream();
                })).limit(4).toList();


        List<MediaItem> recents = new ArrayList<>();
        recents.addAll(recentsPlaylists);
        recents.addAll(recentsSongs);
        Collections.shuffle(recents);
        recents = recents.stream().toList();

        model.addAttribute("recents", recents);

        // Muestra Listas y Canciones por Género

        List<Genre> genres = genreService.findAll();
        Map<String, List<MediaItem>> mediaByGenre = new TreeMap<>();

        for (Genre genre : genres) {

            List<MediaItem> playlists = playlistService.findByGenre(genre).stream().map(PlaylistMediaItemMapper::map).toList();

            List<MediaItem> songs = songService.findByGenre(genre).stream().map(SongMediaItemMapper::map).toList();

            List<MediaItem> mediaItems = new ArrayList<>();
            mediaItems.addAll(playlists);
            mediaItems.addAll(songs);
            Collections.shuffle(mediaItems);

            if(!mediaItems.isEmpty())
                mediaByGenre.put(genre.getName(), mediaItems);

        }

        model.addAttribute("mediaByGenre", mediaByGenre);

        return "principalpage/principalpage";
    }
}
