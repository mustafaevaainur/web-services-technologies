package ru.itmo.webservices.lab1.standalone;

        import javax.xml.ws.Endpoint;

public class AppStarter {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/AlbumService";
        Endpoint.publish(url, new AlbumWebService());
    }
}
