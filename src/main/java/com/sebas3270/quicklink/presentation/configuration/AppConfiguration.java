package com.sebas3270.quicklink.presentation.configuration;

import com.sebas3270.quicklink.domain.datasources.LinksDatasource;
import com.sebas3270.quicklink.domain.repositories.LinksRepository;
import com.sebas3270.quicklink.infrastructure.datasources.jpa.LinksDatasourceImpl;
import com.sebas3270.quicklink.infrastructure.datasources.jpa.LinksJpaRepository;
import com.sebas3270.quicklink.infrastructure.repositories.LinksRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public LinksDatasource linksDatasource(LinksJpaRepository linksJpaRepository){
        return new LinksDatasourceImpl(linksJpaRepository);
    }

    @Bean
    public LinksRepository linksRepository(LinksDatasource linksDatasource){
        return new LinksRepositoryImpl(linksDatasource);
    }
}
