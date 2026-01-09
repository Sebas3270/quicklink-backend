package com.sebas3270.quicklink.domain.datasources;

import com.sebas3270.quicklink.domain.entities.Link;

import java.util.List;
import java.util.Optional;

public abstract class LinksDatasource {
    public abstract Link saveLink(String originalLink);
    public abstract Optional<Link> getLinkByShortUrl(String id);
    public abstract Optional<Link> getLinkByOriginalLink(String originalLink);
    public abstract List<Link> getAllLinks();
    public abstract Link updateLink(Link link);
    public abstract Link deleteLink(Link link);
}