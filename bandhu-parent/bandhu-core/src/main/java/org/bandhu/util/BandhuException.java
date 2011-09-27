package org.bandhu.util;

public class BandhuException extends Exception {

    public BandhuException(Exception exception) {
        super(exception);
    }

    public BandhuException(String message) {
        super(message);
    }

}
