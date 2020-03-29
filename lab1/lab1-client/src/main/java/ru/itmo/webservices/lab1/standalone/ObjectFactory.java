
package ru.itmo.webservices.lab1.standalone;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the ru.itmo.webservices.lab1.standalone package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAlbumsResponse_QNAME = new QName("http://standalone.lab1.webservices.itmo.ru/", "getAlbumsResponse");
    private final static QName _GetAlbums_QNAME = new QName("http://standalone.lab1.webservices.itmo.ru/", "getAlbums");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.itmo.webservices.lab1.standalone
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAlbums }
     */
    public GetAlbums createGetAlbums() {
        return new GetAlbums();
    }

    /**
     * Create an instance of {@link GetAlbumsResponse }
     */
    public GetAlbumsResponse createGetAlbumsResponse() {
        return new GetAlbumsResponse();
    }

    /**
     * Create an instance of {@link Album }
     */
    public Album createAlbum() {
        return new Album();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlbumsResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://standalone.lab1.webservices.itmo.ru/", name = "getAlbumsResponse")
    public JAXBElement<GetAlbumsResponse> createGetAlbumsResponse(GetAlbumsResponse value) {
        return new JAXBElement<GetAlbumsResponse>(_GetAlbumsResponse_QNAME, GetAlbumsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlbums }{@code >}}
     */
    @XmlElementDecl(namespace = "http://standalone.lab1.webservices.itmo.ru/", name = "getAlbums")
    public JAXBElement<GetAlbums> createGetAlbums(GetAlbums value) {
        return new JAXBElement<GetAlbums>(_GetAlbums_QNAME, GetAlbums.class, null, value);
    }

}
