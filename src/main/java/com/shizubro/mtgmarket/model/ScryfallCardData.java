package com.shizubro.mtgmarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "scryfall_card_data")
public class ScryfallCardData {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    // card name
    @Column(name = "cardname", nullable = false)
    private String cardName;

    // card image URL
    @Column(name = "imageurl")
    private String cardImageUrl;

    @UpdateTimestamp
    private Instant updatedAt;

    @CreationTimestamp
    private Instant createdAt;

}