package ru.itmo.webservices.lab1.standalone.dao;

public class QueryBuilder {
    public static String build(String singerId, Long songsCount, String albumName, String genre, Long dateAdded) {
        StringBuilder builder = new StringBuilder(0);
        if (singerId != null) {
            builder.append(String.format("singer_id='%s'", singerId));
        }
        if (songsCount != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and songs_count=%d", songsCount));
            } else {
                builder.append(String.format("songs_count=%d", songsCount));
            }
        }
        if (albumName != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and album_name='%s'", albumName));
            } else {
                builder.append(String.format("album_name='%s'", albumName));
            }
        }
        if (genre != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and genre='%s'", genre));
            } else {
                builder.append(String.format("genre='%s'", genre));
            }
        }
        if (dateAdded != null) {
            if (builder.length() != 0) {
                builder.append(String.format("and date_added=%d", dateAdded));
            } else {
                builder.append(String.format("date_added=%d", dateAdded));
            }
        }
        if (builder.length() != 0) {
            return "select * from album where " + builder.toString();
        } else {
            return "select * from album;";
        }
    }
}
