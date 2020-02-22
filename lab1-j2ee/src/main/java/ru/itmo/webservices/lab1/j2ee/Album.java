package ru.itmo.webservices.lab1.j2ee;

public class Album {
    private String singerId;
    private Long songsCount;
    private String albumName;
    private String genre;
    private Long dateAdded;

    public Album() {
    }

    public Album(String singerId, Long songsCount, String albumName, String genre, Long dateAdded) {
        this.singerId = singerId;
        this.songsCount = songsCount;
        this.albumName = albumName;
        this.genre = genre;
        this.dateAdded = dateAdded;
    }

    public String getAlbumId() {
        return singerId;
    }

    public void setAlbumId(String singerId) {
        this.singerId = singerId;
    }

    public Long getsongsCount() {
        return songsCount;
    }

    public void setsongsCount(Long songsCount) {
        this.songsCount = songsCount;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Album{" +
                "singerId='" + singerId + '\'' +
                ", songsCount=" + songsCount +
                ", albumName='" + albumName + '\'' +
                ", genre='" + genre + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
