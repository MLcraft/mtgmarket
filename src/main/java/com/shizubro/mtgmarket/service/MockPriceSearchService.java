package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.cache.CardCache;
import com.shizubro.mtgmarket.cache.CardCacheRepository;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;
import com.shizubro.mtgmarket.enums.CardCondition;
import com.shizubro.mtgmarket.enums.CardLang;
import com.shizubro.mtgmarket.enums.CardShop;
import com.shizubro.mtgmarket.repository.CardRepository;
import com.shizubro.mtgmarket.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component("mockPriceSearchService")
public class MockPriceSearchService {
    @Autowired
    ListingRepository listingRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardCacheRepository cardCacheRepository;

    public Set<Listing> getCardPriceByFilters(String cardName) {
        Set<Listing> resultSet = new HashSet<Listing>();
        String testCardName = "Test Card Name";

        if (cardCacheRepository.existsByName(testCardName)) {
            CardCache cachedCard = this.cardCacheRepository.findByName(testCardName);
            System.out.println("awehfjklweawerwerwehfkljahf");
            UUID cardOracleId = cachedCard.getOracleId();
            System.out.println("awehfjklweahfkljahf");
            Optional<Card> testCard = this.cardRepository.findById(cardOracleId);
            System.out.println("awehfjklwea");
            testCard.ifPresent(card -> System.out.println(card.getCardName()));
        } else {
            UUID cardOracleId = UUID.randomUUID();
            Card testCard = new Card();
            testCard.setOracleId(cardOracleId);
            testCard.setCardName(testCardName);
            this.cardRepository.save(testCard);
            CardCache cachedCard = new CardCache();
            cachedCard.setName("Test Card Name");
            cachedCard.setOracleId(cardOracleId);

            this.cardCacheRepository.save(cachedCard);

            Listing testListing = new Listing();
            testListing.setCard(testCard);
            testListing.setId(1l);
            testListing.setSource(CardShop.HARERUYA);
            testListing.setLang(CardLang.EN);
            testListing.setSetCode("TSC");
            testListing.setCardNumber("001A");
            testListing.setFoil(false);
            testListing.setListingUrl("https://www.hareruyamtg.com/ja/products/detail/157898?lang=EN");
            testListing.setPrice(BigInteger.valueOf(10000));
            testListing.setCondition(CardCondition.SP);
            testListing.setCardImageUrl("https://cards.scryfall.io/png/front/5/4/5447a777-769d-4773-ab64-31c67e310e15.png");
            testListing.setUpdatedAt(Instant.parse("2024-11-30T18:35:24.00Z"));
            testListing.setCreatedAt(Instant.parse("2024-09-23T12:13:42.00Z"));

            this.listingRepository.save(testListing);
            resultSet.add(testListing);
        }
        return resultSet;
    }
}
