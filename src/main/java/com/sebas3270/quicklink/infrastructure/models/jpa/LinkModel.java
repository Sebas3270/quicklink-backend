package com.sebas3270.quicklink.infrastructure.models.jpa;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "links")
public class LinkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_url", length = 20)
    private String shortUrl;

    @Column(name = "original_link", length = 500)
    private String originalLink;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
