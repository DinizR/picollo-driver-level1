/*
* BadRequestException.java
 */
package org.picollo.resource.exception;

/*
 * Generic API exception for HTTP 400 Error
 * @author rod
 * @since 2019-03-25
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
