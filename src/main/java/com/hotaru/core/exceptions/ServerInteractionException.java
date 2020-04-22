package com.hotaru.core.exceptions;

import com.hotaru.business.errors.ErrorType;

public abstract class ServerInteractionException extends HotaruException {

    public ServerInteractionException() {
    }

    public ServerInteractionException(String message) {
        super(message);
    }

    public ServerInteractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerInteractionException(Throwable cause) {
        super(cause);
    }

    public ServerInteractionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract ErrorType getType();

    @Override
    public String getMessage() {
        return getType().name();
    }
}
