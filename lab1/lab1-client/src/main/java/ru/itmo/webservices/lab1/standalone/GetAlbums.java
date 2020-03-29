
package ru.itmo.webservices.lab1.standalone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlbums complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getAlbums">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="singerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="songsCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="albumName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateAdded" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlbums", propOrder = {
        "singerId",
        "songsCount",
        "albumName",
        "genre",
        "dateAdded"
})
public class GetAlbums {

    protected String singerId;
    protected Long songsCount;
    protected String albumName;
    protected String genre;
    protected Long dateAdded;

    /**
     * Gets the value of the singerId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSingerId() {
        return singerId;
    }

    /**
     * Sets the value of the singerId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSingerId(String value) {
        this.singerId = value;
    }

    /**
     * Gets the value of the songsCount property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getSongsCount() {
        return songsCount;
    }

    /**
     * Sets the value of the songsCount property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSongsCount(Long value) {
        this.songsCount = value;
    }

    /**
     * Gets the value of the albumName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Sets the value of the albumName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAlbumName(String value) {
        this.albumName = value;
    }

    /**
     * Gets the value of the genre property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the dateAdded property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets the value of the dateAdded property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setDateAdded(Long value) {
        this.dateAdded = value;
    }

}
