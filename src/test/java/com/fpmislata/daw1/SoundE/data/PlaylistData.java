package com.fpmislata.daw1.SoundE.data;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

import java.time.LocalDate;
import java.util.List;

public class PlaylistData {
    public static final List<Playlist> PLAYLIST_LIST = List.of(
            new Playlist(1L, "Gorillaz", "gorillaz.jpg", "Gorillaz", "gorillaz.jpg", LocalDate.parse("2025-05-06"),null),
            new Playlist(2L, "Windows I", "windows.jpg", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"),null),
            new Playlist(3L, "Yes. Yes. Yes. Yes. Yes", "yes_yes.jpg", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"),null),
            new Playlist(4L, "Lo-Fi Beats", "lofi.jpg", "Lo-Fi Beats", "lofi.jpg", LocalDate.parse("2025-05-06"),null)
    );
}
