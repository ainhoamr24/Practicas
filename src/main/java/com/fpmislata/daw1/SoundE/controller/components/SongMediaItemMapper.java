package com.fpmislata.daw1.SoundE.controller.components;

import com.fpmislata.daw1.SoundE.domain.entity.Song;

public class SongMediaItemMapper {
    public static MediaItem map(Song song) {
        MediaItem media = new MediaItem();
        media.setName(song.getName());
        media.setType("Song");
        media.setUrl("song/" + song.getId());
        media.setImgPath("/files/song/" + (song.getImgPath() != null ? song.getImgPath() : "example.jpg"));
        return media;
    }
}
