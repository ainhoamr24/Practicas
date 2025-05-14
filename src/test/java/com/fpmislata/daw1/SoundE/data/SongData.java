package com.fpmislata.daw1.SoundE.data;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.time.LocalDate;
import java.util.List;

public class SongData {
    public static final List<Song> SONG_LIST = List.of(
            new Song(1L, "gorillaz.jpg", 270L, "Re-Hash", "Gorillaz", "gorillaz.jpg", LocalDate.parse("2025-05-06"), null, "https://www.youtube.com/watch?v=Z3aC2SptDag"),
            new Song(2L, "gorillaz.jpg", 194L, "5/4", "Gorillaz", "gorillaz.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/z46bm9HR7L4?si=KKDxTlR6_9uGma_z"),
            new Song(3L, "windows.jpg", 194L, "Shy", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/AgbOhWl20PY?si=HbN2Uo5Ka9VpFl8a"),
            new Song(4L, "windows.jpg", 194L, "Televised", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/uGaXjy6-hG0?si=F6dBBqAeoyAxCOhe"),
            new Song(5L, "yes_yes.jpg", 194L, "Lula, I'm Not Mad", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/Yd5hcCHwQA0?si=bcVBQ3jlCfctuHyp"),
            new Song(6L, "yes_yes.jpg", 194L, "Change Ur Mind", "HUNNY", "hunny.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/RNxFaAfnE10?si=oohgrWH_dYTE09QG"),
            new Song(7L, "lofi.jpg", 185L, "Midnight Study", "Lo-Fi Beats", "lofi.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/1tUPFQ54gqc?si=QLu9f4kxjhKBbXvt"),
            new Song(8L, "lofi.jpg", 210L, "Coffee Break", "Lo-Fi Beats", "lofi.jpg", LocalDate.parse("2025-05-06"), null, "https://youtu.be/PElArDnvIxU?si=xZDT685WDXMBt6ng")
    );
}
