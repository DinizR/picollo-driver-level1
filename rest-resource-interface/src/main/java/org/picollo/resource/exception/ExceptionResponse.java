/*
* ExceptionResponse.java
 */
package org.picollo.resource.exception;

import java.time.LocalDateTime;

/*
* Model class to transport exception information between layers.
* @author rod
* @since 2018-03-25
 */
public class ExceptionResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}