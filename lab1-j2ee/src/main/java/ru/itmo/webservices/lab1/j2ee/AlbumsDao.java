package ru.itmo.webservices.lab1.j2ee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlbumsDao {
    private Connection connection = null;

    public AlbumsDao(Connection connection) {
        this.connection = connection;
    }

    public List<Album> getAlbums(String singerId, Long songsCount, String albumName, String genre, Long dateAdded) {
        List<Album> albums = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    QueryBuilder.build(
                            singerId,
                            songsCount,
                            albumName,
                            genre,
                            dateAdded
                    )
            );

            while (rs.next()) {
                albums.add(
                        new Album(
                                rs.getString("singer_id"),
                                rs.getLong("songs_count"),
                                rs.getString("album_name"),
                                rs.getString("genre"),
                                rs.getLong("date_added")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlbumsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return albums;
    }
}