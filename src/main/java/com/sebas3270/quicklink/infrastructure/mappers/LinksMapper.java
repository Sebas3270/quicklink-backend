package com.sebas3270.quicklink.infrastructure.mappers;

import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.infrastructure.models.jpa.LinkModel;

public class LinksMapper {
    public static LinkModel entityToJpa(Link link){
        LinkModel linkModel = new LinkModel();
        linkModel.setOriginalLink(link.getOriginalUrl());
        linkModel.setShortUrl(link.getShortUrl());
        return linkModel;
    }

    public static Link jpaToEntity(LinkModel linkModel){
        Link link = new Link();
        link.setShortUrl(linkModel.getShortUrl());
        link.setOriginalUrl(linkModel.getOriginalLink());
        return link;
    }
}
