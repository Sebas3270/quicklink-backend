package com.sebas3270.quicklink.infrastructure.mappers;

import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.infrastructure.models.jpa.LinkModel;

import java.util.Optional;

public class LinksMapper {
    public static LinkModel entityToJpa(Link link){
        LinkModel linkModel = new LinkModel();
        linkModel.setId(Optional.ofNullable(link.getId()).map(Long::parseLong).orElse(null));
        linkModel.setOriginalLink(link.getOriginalUrl());
        linkModel.setShortUrl(link.getShortUrl());
        return linkModel;
    }

    public static Link jpaToEntity(LinkModel linkModel){
        Link link = new Link();
        link.setId(linkModel.getId().toString());
        link.setShortUrl(linkModel.getShortUrl());
        link.setOriginalUrl(linkModel.getOriginalLink());
        link.setCreatedAt(linkModel.getCreatedAt());
        link.setUpdatedAt(linkModel.getUpdatedAt());
        return link;
    }
}
