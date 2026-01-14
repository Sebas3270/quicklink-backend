package com.sebas3270.quicklink.domain.repositories;

import com.sebas3270.quicklink.domain.entities.Link;

public abstract class LinksRepository {
    public abstract Link postLink(String originalLink);
    public abstract Link getLink(String id);
    public abstract Link getStatsLink(String id);
    public abstract Link updateLink(String shortCode, String link);
    public abstract Link deleteLink(String shortCode);
}
