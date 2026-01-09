package com.sebas3270.quicklink.infrastructure.datasources.jpa;

import com.sebas3270.quicklink.domain.datasources.LinksDatasource;
import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.domain.helpers.ShortKeyGenerator;
import com.sebas3270.quicklink.infrastructure.mappers.LinksMapper;
import com.sebas3270.quicklink.infrastructure.models.jpa.LinkModel;

import java.util.List;
import java.util.Optional;

public class LinksDatasourceImpl extends LinksDatasource {

    private final LinksJpaRepository linksJpaRepository;

    public LinksDatasourceImpl(LinksJpaRepository linksJpaRepository) {
        this.linksJpaRepository = linksJpaRepository;
    }

    @Override
    public Link saveLink(String originalLink) {
        LinkModel linkModel = new LinkModel();
        linkModel.setOriginalLink(originalLink);
        linkModel.setShortUrl(ShortKeyGenerator.generate());
        linkModel = linksJpaRepository.save(linkModel);

        return LinksMapper.jpaToEntity(linkModel);
    }



    @Override
    public Optional<Link> getLinkByShortUrl(String id) {
         return linksJpaRepository.findByShortUrl(id).map(LinksMapper::jpaToEntity);
    }

    @Override
    public Optional<Link> getLinkByOriginalLink(String originalLink) {
        return linksJpaRepository.findByOriginalLink(originalLink).map(LinksMapper::jpaToEntity);
    }

    @Override
    public List<Link> getAllLinks() {
        return linksJpaRepository.findAll().stream().map(LinksMapper::jpaToEntity).toList();
    }

    @Override
    public Link updateLink(Link link) {
        LinkModel linkModel = LinksMapper.entityToJpa(link);
        return LinksMapper.jpaToEntity(linksJpaRepository.save(linkModel));
    }

    @Override
    public Link deleteLink(Link link) {
        LinkModel linkModel = LinksMapper.entityToJpa(link);
        linksJpaRepository.delete(linkModel);
        return link;
    }
}
