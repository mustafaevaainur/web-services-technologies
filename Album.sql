CREATE TABLE Album
(
  album_id   bigserial primary key,
  singer_id    varchar NOT NULL,
  songs_count      BIGINT  NOT NULL,
  album_name varchar NOT NULL,
  genre varchar NOT NULL,
  date_added   BIGINT NOT NULL
);