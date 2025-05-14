insert into tb_song(name, artist, artistImgPath, seconds, dateCreate, imgPath, url) values
    ('Re-Hash', 'Gorillaz', 'gorillaz.jpg', 270, '2025-05-06', 'gorillaz.jpg', 'https://www.youtube.com/watch?v=Z3aC2SptDag'),
    ('5/4', 'Gorillaz', 'gorillaz.jpg', 194, '2025-05-06', 'gorillaz.jpg', 'https://youtu.be/z46bm9HR7L4?si=KKDxTlR6_9uGma_z'),
    ('Shy', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'windows.jpg', 'https://youtu.be/AgbOhWl20PY?si=HbN2Uo5Ka9VpFl8a'),
    ('Televised', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'windows.jpg', 'https://youtu.be/uGaXjy6-hG0?si=F6dBBqAeoyAxCOhe'),
    ('Lula, I''m Not Mad', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'yes_yes.jpg', 'https://youtu.be/Yd5hcCHwQA0?si=bcVBQ3jlCfctuHyp'),
    ('Change Ur Mind', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'yes_yes.jpg', 'https://youtu.be/RNxFaAfnE10?si=oohgrWH_dYTE09QG'),
    ('Midnight Study', 'Lo-Fi Beats', 'lofi.jpg', 185, '2025-05-06', 'lofi.jpg', 'https://youtu.be/1tUPFQ54gqc?si=QLu9f4kxjhKBbXvt'),
    ('Coffee Break', 'Lo-Fi Beats', 'lofi.jpg', 210, '2025-05-06', 'lofi.jpg', 'https://youtu.be/PElArDnvIxU?si=xZDT685WDXMBt6ng');

insert into tb_playlist(name, artist, artistImgPath, dateCreate, imgPath) values
    ('Gorillaz', 'Gorillaz', 'gorillaz.jpg', '2025-05-06', 'gorillaz.jpg'),
    ('Windows I', 'HUNNY', 'hunny.jpg', '2025-05-06', 'windows.jpg'),
    ('Yes. Yes. Yes. Yes. Yes', 'HUNNY', 'hunny.jpg', '2025-05-06', 'yes_yes.jpg'),
    ('Lo-Fi Beats', 'Lo-Fi Beats', 'lofi.jpg', '2025-05-06', 'lofi.jpg');

insert into tb_playlistSong(pls_id_playlist, pls_id_song) values
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8);

insert into tb_genre (name, dateCreate, imgPath) values
    ('Alternative Rock', '2025-05-06', 'alternative_rock.jpg'),
    ('Indie Rock', '2025-05-06', 'indie_rock.jpg'),
    ('Lo-Fi', '2025-05-06', 'lofi_genre.jpg'),
    ('Trip Hop', '2025-05-06', 'trip_hop.jpg'),
    ('Electronic', '2025-05-06', 'electronic.jpg');

insert into tb_songGenres (sgr_id_song, sgr_id_genre) values
    (1, 4),
    (1, 1),
    (2, 4),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 2),
    (6, 2),
    (7, 3),
    (7, 5),
    (8, 3),
    (8, 5);