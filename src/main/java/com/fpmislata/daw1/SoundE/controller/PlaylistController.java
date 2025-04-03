package com.fpmislata.daw1.SoundE.controller;

import com.fpmislata.daw1.SoundE.common.container.PlaylistIoc;
import com.fpmislata.daw1.SoundE.common.container.SongIoc;
import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.PlaylistService;
import com.fpmislata.daw1.SoundE.domain.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PlaylistController {

    private final PlaylistService playlistService;
    private final SongService songService;

    public PlaylistController() {
        this.playlistService = PlaylistIoc.createService();
        this.songService = SongIoc.createService();
    }

    @GetMapping("/playlist")
    public String getPlaylist(Model model, @PathVariable(value = "id") Long id) {
        Playlist playlist = playlistService.findById(id);
        model.addAttribute("playlist", playlist);

        Song song = songService.findById(id);
        model.addAttribute("song", song);

        return "playlistPageTL";
    }
}