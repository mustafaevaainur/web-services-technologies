package service.exceptions;

import service.PictureServiceFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "service.PictureServiceFault")
public class InsertingException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final PictureServiceFault fault;

    public InsertingException(String message, PictureServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public InsertingException(String message, PictureServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public PictureServiceFault getFaultInfo() {
        return fault;
    }
}
