package com.sebas3270.quicklink.domain.entities;

import lombok.Data;

@Data
public class Link {
    private String shortUrl;
    private String originalUrl;
}