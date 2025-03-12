drop database if exists SoundE;
create database SoundE;
use SoundE;
create table if not exists user (
    id_usr int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    birthDate date not null,
    dateCreate date not null,
    imgPath varchar(255)
);

create table if not exists song (
    id_song int primary key auto_increment,
    name varchar(255) not null,
    seconds bigint not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists playlist (
    id_playlist int primary key auto_increment,
    name varchar(255) not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists genre (
    id_genre int primary key auto_increment,
    name varchar(255) not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists reproduce (
    rpd_id_usr int,
    rpd_id_song int,
    primary key (rpd_id_usr, rpd_id_song),
    foreign key (rpd_id_usr) references user(id_usr),
    foreign key (rpd_id_song) references song(id_song)
);

create table if not exists tb_playlistSong (
    pls_id_playlist int,
    pls_id_song int,
    primary key (pls_id_playlist, pls_id_song),
    foreign key (pls_id_playlist) references playlist(id_playlist),
    foreign key (pls_id_song) references song(id_song)
);

create table if not exists tb_songGenres (
    genre_id_song int,
    genre_id_genre int,
    primary key (genre_id_song, genre_id_genre),
    foreign key (genre_id_song) references song(id_song),
    foreign key (genre_id_genre) references genre(id_genre)
);

insert into `user` values (1, 'juanhl123', 'juan123', 'juan@juan.com', '2006-02-24', '2024-02-02', '/img/user1.png'),
(2, 'martast456', 'marta456', 'marta@marta.com', '2002-04-12', '2021-05-07', '/img/user2.png'),
(3, 'sofialn789', 'sofia789', 'sofia@sofia.com', '2004-01-14', '2018-03-08', '/img/user3.png');
insert into `song` values (1, 'Happily', '175', '2013-11-25', '/img/happily.png'),
(2, 'Defenceless', '223', '2020-01-31', '/img/defenceless.png'),
(3, 'Imagination', '217', '2015-04-14', '/img/imagination.png');
insert into `playlist` values (1, 'Las mejores canciones', '2024-03-06', '/img/playlist1.png'),
(2, 'Mix triste', '2022-05-06', '/img/playlist2.png'),
(3, 'Mix alegre', '2020-03-09', '/img/playlist3.png');
insert into `genre` values (1, 'pop', '2020-06-07', '/img/pop.png'),
(2, 'rock', '2010-10-20', '/img/rock.png'),
(3, 'trap', '2012-12-12', '/img/trap.png');
insert into `reproduce` values (1, 2),
(1, 3),
(2, 3);
insert into `tb_playlistSong` values (2, 1),
(3, 1),
(2, 3);
insert into `tb_songGenres` values (1, 3),
(2, 1),
(1, 2);

select *
from user
where dateCreate < '2020-01-01';

select *
from song
where name = 'Defenceless';

select *
from playlist
where dateCreate > '2022-01-01';

select *
from genre
where name = 'pop';

select *
from reproduce
where rpd_id_usr = 1;

select *
from tb_playlistSong
where pls_id_playlist = 2;

select *
from tb_songGenres
where genre_id_genre = 2;