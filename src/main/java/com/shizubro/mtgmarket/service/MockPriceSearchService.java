package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.cache.CardCache;
import com.shizubro.mtgmarket.cache.CardCacheRepository;
import com.shizubro.mtgmarket.dto.ListingDto;
import com.shizubro.mtgmarket.mapper.Mapper;
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
import java.util.*;

@Component("mockPriceSearchService")
public class MockPriceSearchService {
    private final ListingRepository listingRepository;
    private final CardRepository cardRepository;
    private final CardCacheRepository cardCacheRepository;
    private final Mapper mapper;

    @Autowired
    public MockPriceSearchService(ListingRepository listingRepository, CardRepository cardRepository, CardCacheRepository cardCacheRepository, Mapper mapper) {
        this.listingRepository = listingRepository;
        this.cardRepository = cardRepository;
        this.cardCacheRepository = cardCacheRepository;
        this.mapper = mapper;
    }

    public List<ListingDto> getCardPriceByFilters(String cardName) {
        List<ListingDto> resultSet = new ArrayList<>();
        String testCardName = cardName;

        if (cardCacheRepository.existsByName(testCardName)) {
            CardCache cachedCard = this.cardCacheRepository.findByName(testCardName);
            UUID cardOracleId = cachedCard.getOracleId();
            Optional<Card> testCard = this.cardRepository.findById(cardOracleId);
            testCard.ifPresent(card -> System.out.println(card.getCardName()));
        } else {
            UUID cardOracleId = UUID.randomUUID();
            Card testCard = new Card();
            testCard.setOracleId(cardOracleId);
            testCard.setCardName(testCardName);
            this.cardRepository.save(testCard);
            CardCache cachedCard = new CardCache();
            cachedCard.setName(cardName);
            cachedCard.setOracleId(cardOracleId);

            this.cardCacheRepository.save(cachedCard);

            Listing testListing = new Listing();
            testListing.setCard(testCard);
            testListing.setId(1l);
            testListing.setSource(CardShop.HARERUYA);
            testListing.setLang(CardLang.EN);
            testListing.setSetCode("TSC");
            testListing.setCardNumber("001A");
            testListing.setFoil(true);
            testListing.setListingUrl("https://www.hareruyamtg.com/ja/products/detail/157898?lang=EN");
            testListing.setPrice(BigInteger.valueOf(10000));
            testListing.setCondition(CardCondition.SP);
            testListing.setCardImageUrl("https://cards.scryfall.io/png/front/5/4/5447a777-769d-4773-ab64-31c67e310e15.png");
            testListing.setUpdatedAt(Instant.parse("2024-11-30T18:35:24.00Z"));
            testListing.setCreatedAt(Instant.parse("2024-09-23T12:13:42.00Z"));

            this.listingRepository.save(testListing);
            resultSet.add(this.mapper.listingToDto(testListing));
            testListing.setFoil(false);
            testListing.setSource(CardShop.SERRA);
            testListing.setLang(CardLang.JP);
            testListing.setPrice(BigInteger.valueOf(23424));
            this.listingRepository.save(testListing);
            resultSet.add(this.mapper.listingToDto(testListing));
        }
        return resultSet;
    }
}
