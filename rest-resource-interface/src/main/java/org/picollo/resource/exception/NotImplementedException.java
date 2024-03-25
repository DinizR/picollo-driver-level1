/*
* NotImplementedException.java
 */
package org.picollo.resource.exception;

/*
 * Generic API exception for HTTP 501 Error
 * @author rod
 * @since 2019-03-25
 */
public class NotImplementedException extends RuntimeException {
    public NotImplementedException(String message) {
        super(message);
    }
}
