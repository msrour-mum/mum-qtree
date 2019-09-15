package edu.mum.qtree.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception{

    private int errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public BusinessException(String errorMessage, Throwable ex, HttpStatus httpStatus, int errorCode)
    {
        super(errorMessage, ex);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public BusinessException(String errorMessage, Throwable ex)
    {
        super(errorMessage, ex);
        this.errorCode = 0;
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(String errorMessage)
    {
        super(errorMessage, new Exception(errorMessage));
        this.errorCode = 0;
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(String errorMessage, HttpStatus httpStatus)
    {
        super(errorMessage, new Exception(errorMessage));
        this.errorCode = 0;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public BusinessException(String errorMessage, int errorCode, HttpStatus httpStatus)
    {
        super(errorMessage, new Exception(errorMessage));
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
