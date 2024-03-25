/*
* GeneralException.java
*/
package org.picollo.resource.exception;

/*
 * Generic API exception for HTTP 500 Error
 * @author rod
 * @since 2019-03-25
 */
public class GeneralException extends RuntimeException {
    public GeneralException(String message) {
        super(message);
    }
}
