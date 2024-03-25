package org.cobra.worker.api;

public class WorkerException extends Exception {
    private int errCode;

    public WorkerException(String message) {
        super(message);
    }
    public WorkerException(String message,Throwable throwable) {
        super(message,throwable);
    }

    public WorkerException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
