package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;
import com.shizubro.mtgmarket.enums.CARDCONDITION;
import com.shizubro.mtgmarket.enums.CARDLANG;
import com.shizubro.mtgmarket.enums.CARDSHOP;
import com.shizubro.mtgmarket.repository.CardRepository;
import com.shizubro.mtgmarket.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component("mockPriceSearchService")
public class MockPriceSearchService {
    @Autowired
    ListingRepository listingRepository;

    @Autowired
    CardRepository cardRepository;

    public Set<Listing> getCardPriceByFilters(String cardName) {
        Set<Listing> resultSet = new HashSet<Listing>();
        Card testCard = new Card();
        UUID cardOracleId = UUID.randomUUID();
        testCard.setOracleId(cardOracleId);
        testCard.setCardName("Test Card Name");
        this.cardRepository.save(testCard);

        Listing testListing = new Listing();
        testListing.setCard(testCard);
        testListing.setId(1l);
        testListing.setSource(CARDSHOP.SERRA);
        testListing.setLang(CARDLANG.EN);
        testListing.setSetCode("TSC");
        testListing.setCardNumber("001A");
        testListing.setFoil(false);
        testListing.setListingUrl("listing.url");
        testListing.setPrice(BigInteger.valueOf(10000));
        testListing.setCondition(CARDCONDITION.SP);
        testListing.setCardImageUrl("cardimage.url");
        testListing.setUpdatedAt(Instant.parse("2024-11-30T18:35:24.00Z"));
        testListing.setCreatedAt(Instant.parse("2024-09-23T12:13:42.00Z"));

        this.listingRepository.save(testListing);
        return resultSet;
    }
}
