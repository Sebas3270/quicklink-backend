package com.sebas3270.quicklink.presentation.controllers;

import com.sebas3270.quicklink.presentation.dtos.CreateLinkDto;
import com.sebas3270.quicklink.domain.repositories.LinksRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Tag(name = "Links", description = "Links operations")
public class LinkController {

    @Autowired
    private Environment env;

    private final LinksRepository linksRepository;

    @GetMapping("/{shortLink}")
    @Operation(description = "Gets the original link when an exist short url provided")
    ResponseEntity<String> getLinkUrl(@PathVariable String shortLink){
        return ResponseEntity.ok(linksRepository.getLink(shortLink).getOriginalUrl());
    }

    @PostMapping("/api/links")
    @Operation(description = "Saves the link provided a returns the complete short url")
    ResponseEntity<String> saveLink(@Valid @RequestBody CreateLinkDto createLinkDto){
        String shortLink = linksRepository
                .postLink(createLinkDto.url()).getShortUrl();
        String fullShortUrl = env.getProperty("app.base-url")
                + "/" + shortLink;
        return ResponseEntity.ok(fullShortUrl);
    }
}
