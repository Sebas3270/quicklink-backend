package com.sebas3270.quicklink.infrastructure.repositories;

import com.sebas3270.quicklink.domain.datasources.LinksDatasource;
import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.domain.exceptions.AlreadyExistsException;
import com.sebas3270.quicklink.domain.exceptions.NotExistsException;
import com.sebas3270.quicklink.domain.repositories.LinksRepository;

public class LinksRepositoryImpl extends LinksRepository {

    private final LinksDatasource linksDatasource;

    public LinksRepositoryImpl(LinksDatasource linksDatasource) {
        this.linksDatasource = linksDatasource;
    }

    @Override
    public Link postLink(String originalLink) {

        linksDatasource.getLinkByOriginalLink(originalLink).ifPresent(link -> {
            throw new AlreadyExistsException(link.getOriginalUrl(), link.getShortUrl());
        });

        return linksDatasource.saveLink(originalLink);
    }

    @Override
    public Link getLink(String id) {
        Link link = linksDatasource.getLinkByShortUrl(id)
                .orElseThrow(() -> new NotExistsException(id));
        return linksDatasource.increaseLinkViews(link);
    }

    @Override
    public Link updateLink(String shortCode, String link) {
        Link linkObject = this.getLink(shortCode);
        linkObject.setOriginalUrl(link);
        return linksDatasource.updateLink(linkObject);
    }

    @Override
    public Link deleteLink(String shortCode) {
        Link link = this.getLink(shortCode);
        return linksDatasource.deleteLink(link);
    }

}
