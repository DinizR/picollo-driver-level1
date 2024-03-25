/*
* ItemNotFoundException.java
 */
package org.picollo.resource.exception;

/*
* Generic API exception for HTTP 404 Error
* @author rod
* @since 2019-03-25
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}