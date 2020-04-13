package com.hotaru.core.exceptions;

public class HotaruException extends Exception {
    public HotaruException() {
    }

    public HotaruException(String message) {
        super(message);
    }

    public HotaruException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotaruException(Throwable cause) {
        super(cause);
    }

    public HotaruException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
