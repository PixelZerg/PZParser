package com.pixelzerg.parser.pzcsharp.errorhandling;

/**
 * Created by pixelzerg on 18/01/17.
 */
public class PZCSharpException extends Exception {
    public PZCSharpException() {
        super();
    }

    public PZCSharpException(String message) {
        super(message);
    }

    public PZCSharpException(String message, Throwable cause) {
        super(message, cause);
    }

    public PZCSharpException(Throwable cause) {
        super(cause);
    }
}