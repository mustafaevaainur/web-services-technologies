package ru.itmo.webservices.lab1.client;

import ru.itmo.webservices.lab1.standalone.Album;
import ru.itmo.webservices.lab1.standalone.AlbumWebService;
import ru.itmo.webservices.lab1.standalone.AlbumsService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FirstLabClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/AlbumService?wsdl");
        AlbumsService albumsService = new AlbumsService(url);
        AlbumWebService albumsWebService = albumsService.getAlbumWebServicePort();


        System.out.println("Querying all existing Albums");
        List<Album> albums = albumsWebService.getAlbums(null, null, null, null, null);
        for (Album picture : albums) {
            System.out.println(picture.toString());
        }

        System.out.println("Querying all Albums by specific fields");
        List<Album> albums2 = albumsWebService.getAlbums(null, 16L, null, "genre", null);
        for (Album picture : albums2) {
            System.out.println(picture.toString());
        }
    }
}