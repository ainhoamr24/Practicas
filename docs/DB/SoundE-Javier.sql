drop database if exists SoundE;
create database SoundE;
use SoundE;
create table if not exists tb_user (
    id_usr int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    birthDate date not null,
    dateCreate date not null,
    imgPath varchar(255)
);

create table if not exists tb_song (
    id_song int primary key auto_increment,
    name varchar(255) not null,
    seconds bigint not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists tb_playlist (
    id_playlist int primary key auto_increment,
    name varchar(255) not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists tb_genre (
    id_genre int primary key auto_increment,
    name varchar(255) not null,
    dateCreate date not null,
    imgPath varchar(255) not null
);

create table if not exists tb_userSong (
    rpd_id_usr int,
    rpd_id_song int,
    primary key (rpd_id_usr, rpd_id_song),
    foreign key (rpd_id_usr) references tb_user(id_usr),
    foreign key (rpd_id_song) references tb_song(id_song)
);

create table if not exists tb_playlistSong (
    pls_id_playlist int,
    pls_id_song int,
    primary key (pls_id_playlist, pls_id_song),
    foreign key (pls_id_playlist) references tb_playlist(id_playlist),
    foreign key (pls_id_song) references tb_song(id_song)
);

create table if not exists tb_songGenres (
    sgr_id_song int,
    sgr_id_genre int,
    primary key (sgr_id_song, sgr_id_genre),
    foreign key (sgr_id_song) references tb_song(id_song),
    foreign key (sgr_id_genre) references tb_genre(id_genre)
);