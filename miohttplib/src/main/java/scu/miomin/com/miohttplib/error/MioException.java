package scu.miomin.com.miohttplib.error;

/**
 * Created by 莫绪旻 on 16/3/16.
 */
public class MioException extends Exception {

    private int errorCode;
    private Exception exception;

    public MioException(int errorCode, Exception exception) {
        this.errorCode = errorCode;
        this.exception = exception;
    }

    public MioException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
