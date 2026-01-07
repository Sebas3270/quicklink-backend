package com.sebas3270.quicklink.domain.exceptions;

public class AlreadyExistsException extends QuickLinkException{

    public AlreadyExistsException(String originalLink, String quickLink) {
        super(409, String.format("Quick link for url: '%s' already exists, please look for: '%s'", originalLink, quickLink));
    }
}
