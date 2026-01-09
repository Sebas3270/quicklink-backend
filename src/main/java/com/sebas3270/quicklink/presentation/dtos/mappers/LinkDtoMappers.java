package com.sebas3270.quicklink.presentation.dtos.mappers;

import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.presentation.dtos.LinkResponseDto;

public class LinkDtoMappers {
    public static LinkResponseDto entityToMapper(Link link){
        return new LinkResponseDto(
                link.getId(),
                link.getOriginalUrl(),
                link.getShortUrl(),
                link.getCreatedAt().toString(),
                link.getUpdatedAt().toString()
        );
    }
}
