drop table if exists song;

CREATE TABLE song
(
    song_id   int primary key auto_increment,
    song_name varchar(200) not null,
    song_year int check (song_year > 0) not null,
    audio_file_path varchar(200) not null,
    photo_file_path varchar(200) not null
);