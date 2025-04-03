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

    // Servicios que van a ser utilizados durante el programa.
    private final PlaylistService playlistService;
    private final SongService songService;
    private final GenreService genreService;

    public MainController() {
        this.playlistService = PlaylistIoc.createService();
        this.songService = SongIoc.createService();
        this.genreService = GenreIoc.createService();
    }

    // Controlador Main, será llamado cuando la dirección sea /.
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String index(Model model) {

        // Para este trozo vamos a hacer 2 conjuntos de 4 siendo estos 4 playlist y 4 canciones, de esta manera que haya siempre 4 de cada. Para que esto sea posible vamos a hacer uso de los MediaItems.

        // Creamos una Lista de MediaItems, y le decimos que va a contener la salida de, primero cogemos todas las playlists y mediante el stream mapeamos su salida para que cada playlist
        // se convierta en un objeto de tipo MediaItem mediante el uso del metodo map que tiene el Mapper, con esta salida la cual tendrá todas las playlist queremos coger solo 4,
        // pero como con el uso de limit siempre nos va a devolver lo mismo vamos a hacer uso del collect(), el cual nos permite coger la salida y hacer un shuffle, de esta manera siempre las 4 son aleatorias.

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

        // Teniendo ya 2 Listas del mismo tipo con 4 objetos cada una vamos a crear la lista que se mandará al thymeleaf, lo que se hace es crearla, añadirle ambas y por último un shuffle para que siempre sea aleatorio como aparece.

        List<MediaItem> recents = new ArrayList<>();
        recents.addAll(recentsPlaylists);
        recents.addAll(recentsSongs);
        Collections.shuffle(recents);
        recents = recents.stream().toList();

        model.addAttribute("recents", recents);

        // Para las secciones que se van a mostrar a lo largo del thymeleaf vamos a trabajar con un TreeMap, el cual nos permite tener una <entrada, valor> y además la entrada este ordenada.

        List<Genre> genres = genreService.findAll();
        Map<String, List<MediaItem>> mediaByGenre = new TreeMap<>();

        for (Genre genre : genres) {

            // Ahora en el bucle creamos las listas de MediaItems igual que anteriormente solo que ahora mediante el uso del servicio findByGenre.
            List<MediaItem> playlists = playlistService.findByGenre(genre).stream().map(PlaylistMediaItemMapper::map).toList();

            List<MediaItem> songs = songService.findByGenre(genre).stream().map(SongMediaItemMapper::map).toList();

            // Por último creamos la lista que contendrá las 2 listas previas y hacemos un shuffle.
            List<MediaItem> mediaItems = new ArrayList<>();
            mediaItems.addAll(playlists);
            mediaItems.addAll(songs);
            Collections.shuffle(mediaItems);

            // Con la lista ya creada, si no está vacia lo cual indicaría que ese género no está en uso, le hacemos un put al TreeMap y ya está listo para ir al Thymeleaf
            if(!mediaItems.isEmpty())
                mediaByGenre.put(genre.getName(), mediaItems);

        }

        model.addAttribute("mediaByGenre", mediaByGenre);

        return "principalpage/principalpage";
    }
}
