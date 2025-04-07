package com.fpmislata.daw1.SoundE.controller;

import com.fpmislata.daw1.SoundE.common.container.SongIoc;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.domain.service.SongService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SongController {

    private final SongService songService;

    public SongController() {
        this.songService = SongIoc.createService();
    }

    @GetMapping("/song/{id}")
    public String getPlaylist(Model model, @PathVariable(value = "id") Long id) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);

        return "songPageTL";
    }
}
