insert into tb_song(name, artist, artistImgPath, seconds, dateCreate, imgPath) values
    ('Re-Hash', 'Gorillaz', 'gorillaz.jpg', 270, '2025-05-06', 'gorillaz.jpg'),
    ('5/4', 'Gorillaz', 'gorillaz.jpg', 194, '2025-05-06', 'gorillaz.jpg'),
    ('Shy', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'windows.jpg'),
    ('Televised', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'windows.jpg'),
    ('Lula, I''m Not Mad', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'yes_yes.jpg'),
    ('Change Ur Mind', 'HUNNY', 'hunny.jpg', 194, '2025-05-06', 'yes_yes.jpg'),
    ('Midnight Study', 'Lo-Fi Beats', 'lofi.jpg', 185, '2025-05-06', 'lofi.jpg'),
    ('Coffee Break', 'Lo-Fi Beats', 'lofi.jpg', 210, '2025-05-06', 'lofi.jpg');

insert into tb_playlist(name, artist, artistImgPath, dateCreate, imgPath) values
    ('Gorillaz', 'Gorillaz', 'gorillaz.jpg', '2025-05-06', 'gorillaz.jpg'),
    ('Windows I', 'HUNNY', 'hunny.jpg', '2025-05-06', 'windows.jpg'),
    ('Yes. Yes. Yes. Yes. Yes', 'HUNNY', 'hunny.jpg', '2025-05-06', 'yes_yes.jpg'),
    ('Lo-Fi Beats', 'Lo-Fi Beats', 'lofi.jpg', '2025-05-06', 'lofi.jpg');

insert into tb_playlistsong(pls_id_playlist, pls_id_song) values
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