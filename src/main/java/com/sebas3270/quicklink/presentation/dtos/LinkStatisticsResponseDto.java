package com.sebas3270.quicklink.presentation.dtos;

public record LinkStatisticsResponseDto(String id, String url, String shortCode, String createdAt, String updatedAt, int accessCount) {
}
