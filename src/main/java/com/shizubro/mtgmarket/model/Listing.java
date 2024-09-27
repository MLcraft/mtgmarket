package com.shizubro.mtgmarket.model;

import com.shizubro.mtgmarket.enums.CARDCONDITION;
import com.shizubro.mtgmarket.enums.CARDLANG;
import com.shizubro.mtgmarket.enums.CARDSHOP;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="card_id", nullable=false)
    private Card card;

    // source
    @Enumerated(EnumType.STRING)
    @Column(name = "source", nullable = false)
    private CARDSHOP source;

    // card language
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "lang", nullable = false)
    private CARDLANG lang;

    // set code
    @Column(name = "set_code", nullable = false)
    private String setCode;

    // card number
    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    // foiling
    @Column(name = "is_foil", nullable = false)
    private boolean isFoil;

    // listing_url
    @Column(name = "listing_url", nullable = false)
    private String listingUrl;

    // price
    @Column(name = "price", nullable = false)
    private BigInteger price;

    // condition
    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false)
    private CARDCONDITION condition;

    // card image url
    @Column(name = "image_url", nullable = false)
    private String cardImageUrl;

    @UpdateTimestamp
    private Instant updatedAt;

    @CreationTimestamp
    private Instant createdAt;
}
