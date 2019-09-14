package edu.mum.qtree.exceptions;

import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private int errorCode;

    public ExceptionResponse(Date date, String message, String details, int errorCode) {

        this.timestamp = date;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;

    }

    public ExceptionResponse(Date date, String message, int errorCode) {

        this.timestamp = date;
        this.message = message;
        this.errorCode = errorCode;

    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
