package ru.itmo.webservices.lab1.standalone;

import ru.itmo.webservices.lab1.standalone.dao.AlbumsDao;
import ru.itmo.webservices.lab1.standalone.pojo.Album;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "AlbumsService")
public class AlbumWebService {
    @WebMethod
    public List<Album> getAlbums(@WebParam(name = "singerId") String singerId,
                                     @WebParam(name = "songsCount") Long songsCount,
                                     @WebParam(name = "albumName") String albumName,
                                     @WebParam(name = "genre") String genre,
                                     @WebParam(name = "dateAdded") Long dateAdded) {
        AlbumsDao dao = new AlbumsDao();
        return dao.getAlbums(singerId, songsCount, albumName, genre, dateAdded);
    }
}