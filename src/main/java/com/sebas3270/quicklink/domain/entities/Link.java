package com.sebas3270.quicklink.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Link {
    private String id;
    private String shortUrl;
    private String originalUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int accessCount;

    public void increaseView(){
        accessCount += 1;
    }
}