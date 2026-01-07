package com.sebas3270.quicklink.presentation.dtos;

import jakarta.validation.constraints.NotEmpty;

public record CreateLinkDto(
        @NotEmpty String originalUrl
) {
}
