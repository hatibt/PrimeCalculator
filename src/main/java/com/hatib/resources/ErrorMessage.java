package com.hatib.resources;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Hatib on 13/05/2016.
 */
public class ErrorMessage {

    private final int status;

    private final String message;

    public ErrorMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("message", message)
                .toString();
    }
}
