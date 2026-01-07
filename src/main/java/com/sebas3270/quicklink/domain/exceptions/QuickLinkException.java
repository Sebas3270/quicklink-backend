package com.sebas3270.quicklink.domain.exceptions;

import lombok.Data;
import lombok.Getter;

@Getter
public class QuickLinkException extends RuntimeException {
    private final int statusCode;
    public QuickLinkException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
