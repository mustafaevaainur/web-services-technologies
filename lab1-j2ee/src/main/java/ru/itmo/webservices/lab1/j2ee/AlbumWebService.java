package ru.itmo.webservices.lab1.j2ee;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "AlbumsService")
public class AlbumWebService {
    @Resource(lookup = "jdbc/mydb")
    private DataSource dataSource;

    @WebMethod
    public List<Album> getAlbums(@WebParam(name = "singerId") String singerId,
                                 @WebParam(name = "songsCount") Long songsCount,
                                 @WebParam(name = "albumName") String albumName,
                                 @WebParam(name = "genre") String genre,
                                 @WebParam(name = "dateAdded") Long dateAdded) {
        AlbumsDao dao = new AlbumsDao(getConnection());
        return dao.getAlbums(singerId, songsCount, albumName, genre, dateAdded);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}