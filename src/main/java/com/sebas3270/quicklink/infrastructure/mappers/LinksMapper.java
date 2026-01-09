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
        linkModel.setCreatedAt(link.getCreatedAt());
        linkModel.setUpdatedAt(link.getUpdatedAt());
        linkModel.setAccessCount(link.getAccessCount());
        return linkModel;
    }

    public static Link jpaToEntity(LinkModel linkModel){
        Link link = new Link();
        link.setId(linkModel.getId().toString());
        link.setShortUrl(linkModel.getShortUrl());
        link.setOriginalUrl(linkModel.getOriginalLink());
        link.setCreatedAt(linkModel.getCreatedAt());
        link.setUpdatedAt(linkModel.getUpdatedAt());
        link.setAccessCount(linkModel.getAccessCount());
        return link;
    }
}
