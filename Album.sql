CREATE TABLE Album
(
  album_id   bigserial primary key,
  singer_id    varchar NOT NULL,
  songs_count      BIGINT  NOT NULL,
  album_name varchar NOT NULL,
  genre varchar NOT NULL,
  date_added   BIGINT NOT NULL
);

INSERT INTO public.album(album_id, singer_id, songs_count, album_name, genre, date_added) VALUES (1, ‘album_id_1', 15, 'album_name', 'genre', 123);
INSERT INTO public.album(album_id,, singer_id, songs_count, album_name, genre, date_added) VALUES (2, ‘album_id_2', 16, 'album_name', 'genre', 124);
INSERT INTO public.album(album_id,, singer_id, songs_count, album_name, genre, date_added) VALUES (3, ‘album_id_3', 17, 'album_name', 'genre', 125);
