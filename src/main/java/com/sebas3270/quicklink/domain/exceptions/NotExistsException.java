package com.sebas3270.quicklink.domain.exceptions;

public class NotExistsException extends QuickLinkException{
    public NotExistsException(String id) {
        super(404, String.format("Quick link for id '%s' does not exist", id));
    }
}
