/*
* BackendException.java
 */
package org.picollo.backend.api;

public class BackendException extends Exception {
    public BackendException(String message) {
        super(message);
    }
    public BackendException(String message, Throwable cause) {
        super(message,cause);
    }
}
