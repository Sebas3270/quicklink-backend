package com.sebas3270.quicklink.infrastructure.datasources.jpa;

import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.infrastructure.models.jpa.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinksJpaRepository extends JpaRepository<LinkModel, Long> {
    Optional<LinkModel> findByShortUrl(String id);
    Optional<LinkModel> findByOriginalLink(String originalLink);
}
