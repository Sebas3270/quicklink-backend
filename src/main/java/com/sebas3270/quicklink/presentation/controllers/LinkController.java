package com.sebas3270.quicklink.presentation.controllers;

import com.sebas3270.quicklink.domain.entities.Link;
import com.sebas3270.quicklink.presentation.dtos.CreateLinkDto;
import com.sebas3270.quicklink.domain.repositories.LinksRepository;
import com.sebas3270.quicklink.presentation.dtos.LinkResponseDto;
import com.sebas3270.quicklink.presentation.dtos.mappers.LinkDtoMappers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shorten")
@Tag(name = "Links", description = "Links operations")
public class LinkController {

    private final LinksRepository linksRepository;

    @GetMapping("/{shortLink}")
    @Operation(description = "Gets the original link when an exist short url provided")
    ResponseEntity<LinkResponseDto> getLinkUrl(@PathVariable String shortLink){
        Link link = linksRepository.getLink(shortLink);
        return ResponseEntity.ok(LinkDtoMappers.entityToMapper(link));
    }

    @PostMapping("/")
    @Operation(description = "Saves the link provided a returns the complete short url")
    ResponseEntity<LinkResponseDto> saveLink(@Valid @RequestBody CreateLinkDto createLinkDto){
        Link link = linksRepository.postLink(createLinkDto.url());
        return ResponseEntity.ok(LinkDtoMappers.entityToMapper(link));
    }

    @PutMapping("/{shortLink}")
    @Operation(description = "Updates the short link with the new link")
    ResponseEntity<LinkResponseDto> updateLink(
            @PathVariable String shortLink,
            @Valid @RequestBody CreateLinkDto createLinkDto)
    {
        Link link = linksRepository.updateLink(shortLink, createLinkDto.url());
        return ResponseEntity.ok(LinkDtoMappers.entityToMapper(link));
    }

    @DeleteMapping("/{shortLink}")
    @Operation(description = "Deletes the short link provided")
    ResponseEntity<LinkResponseDto> deleteLink(@PathVariable String shortLink)
    {
        Link link = linksRepository.deleteLink(shortLink);
        return ResponseEntity.ok(LinkDtoMappers.entityToMapper(link));
    }
}
