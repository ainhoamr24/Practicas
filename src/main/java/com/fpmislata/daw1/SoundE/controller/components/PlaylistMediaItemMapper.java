package com.fpmislata.daw1.SoundE.controller.components;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

public class PlaylistMediaItemMapper {
    public static MediaItem map(Playlist playlist) {
        MediaItem media = new MediaItem();
        media.setName(playlist.getName());
        media.setType("Playlist");
        media.setUrl("playlist/" + playlist.getId());
        media.setImgPath("/files/playlist/" + (playlist.getImgPath() != null ? playlist.getImgPath() : "example.jpg"));
        return media;
    }
}
