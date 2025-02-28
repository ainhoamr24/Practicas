drop database if exists SoundE;
create database SoundE;
use SoundE;

create table if not exists `tb_user`(
    usr_id          int     auto_increment,
    usr_email       text    not null,
    usr_plan        enum('Gratuito','Individual','Duo','Familiar','Estudiantes') not null,
    usr_passwd      text not null,
    usr_mobile      varchar(20) not null,
    usr_name        varchar(20) not null,
    usr_photo       text,
    usr_dateCreate  timestamp default current_timestamp,
    primary key(usr_id)
);

create table if not exists `tb_content`(
    content_id          int auto_increment,
    content_name        varchar(20) not null,
    content_artist      varchar(20) not null,
    content_thumb       text,
    content_dateCreate  timestamp default current_timestamp,
    primary key(content_id)
);

create table if not exists `tb_userPlays`(
    upl_usr_id         int,
    upl_content_id     int,
    upl_dateCreate     timestamp default current_timestamp,
    primary key(upl_usr_id, upl_content_id),
    foreign key(upl_usr_id) references tb_user(usr_id),
    foreign key(upl_content_id) references tb_content(content_id)
);

create table if not exists `tb_song`(
    song_id             int,
    content_minutes     time not null,
    song_lirycs         text,
    primary key(song_id),
    foreign key(song_id) references tb_content(content_id)
);

create table if not exists `tb_list`(
    list_id          int,
    primary key(list_id),
    foreign key(list_id) references tb_content(content_id)
);

create table if not exists `tb_listSongs`(
    lsn_list_id  int,
    lsn_song_id  int,
    lsn_dateCreate timestamp default current_timestamp,
    primary key(lsn_list_id, lsn_song_id),
    foreign key(lsn_list_id) references tb_list(list_id),
    foreign key(lsn_song_id) references tb_song(song_id)
);

create table if not exists `tb_genre`(
    genre_id         int auto_increment,
    genre_name       varchar(20) not null,
    genre_dateCreate timestamp default current_timestamp,
    primary key(genre_id)
);

create table if not exists `tb_songGenres`(
    sgr_song_id  int,
    sgr_genre_id  int,
    primary key(sgr_song_id, sgr_genre_id),
    foreign key(sgr_song_id) references tb_song(song_id),
    foreign key(sgr_genre_id) references tb_genre(genre_id)
);

insert into tb_user(usr_email,usr_plan,usr_passwd,usr_mobile,usr_name) values ('test4@gmail.com','Familiar','meLLamoJavi','+34094573836','Javier');

insert into tb_content(content_name, content_artist) values ('Lose My Mind','Pepito 3');
set @tmp_last_id = LAST_INSERT_ID();
update tb_content set content_thumb = concat('$GLOBAL_DOCUMENTS/songs/',@tmp_last_id,'/',(select content_name where content_id = @tmp_last_id)) where content_id = @tmp_last_id;
insert into tb_song values(@tmp_last_id,'00:02:42',"I can get through this\nI can get through this\nI can get through this\nI can get through this\nI'm 'bout to give her everything she ever wanted and more\nWhat I deliver is something that can't be bought at the store\nI'm tryna bring you with me, baby, while I'm finding myself\nThat feeling when you kiss me tells me I don't need no one else\nI had to lose my mind a couple times to find out it's you\nI had to run around the whole world just to be here, it's true\nThese other women don't got nothing on the way that she move\nLet's pick up right where we left off last night inside of my room\nWhen the time come, I'll be right here\nSippin' liquor with a grin on my face for you\nI got nothing left to keep me awake\nI don't got no better thing to do but sit here and wait for you\nFor you\nFor you\nFor you\nI can get through this (for you)\nI can get through this (for you)\nI can get through this (for you)\nI can get through this");
set @tmp_last_id = null;

insert into tb_content(content_name, content_artist) values ('Changes','Pepe 2');
set @tmp_last_id = LAST_INSERT_ID();
update tb_content set content_thumb = concat('$GLOBAL_DOCUMENTS/songs/',@tmp_last_id,'/',(select content_name where content_id = @tmp_last_id)) where content_id = @tmp_last_id;
insert into tb_list values(@tmp_last_id);
insert into tb_listSongs (lsn_list_id, lsn_song_id) values (@tmp_last_id,(select content_id from tb_content where content_name like '%Lose My%'));
set @tmp_last_id = null;

insert into tb_genre (genre_name) values ('Hip-hop');
insert into tb_genre (genre_name) values ('Rap');

insert into tb_songGenres values ((select song_id from tb_song where song_id = (select content_id from tb_content where content_name = 'Lose My Mind')),(select genre_id from tb_genre where genre_name = 'Hip-hop'));
insert into tb_songGenres values ((select song_id from tb_song where song_id = (select content_id from tb_content where content_name = 'Lose My Mind')),(select genre_id from tb_genre where genre_name = 'Rap'));

insert into tb_userPlays (upl_usr_id, upl_content_id) values ((select usr_id from tb_user where usr_name = 'Javier'), (select content_id from tb_content where content_name='Lose My Mind'));