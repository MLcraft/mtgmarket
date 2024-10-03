package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.cache.CardCache;
import com.shizubro.mtgmarket.cache.CardCacheRepository;
import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.dto.ListingDto;
import com.shizubro.mtgmarket.mapper.Mapper;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.repository.CardRepository;
import com.shizubro.mtgmarket.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("priceSearchService")
public class PriceSearchService {
    private final ScryfallService scryfallService;
    private final StoreScraperService storeScraperService;
    private final ListingRepository listingRepository;
    private final CardRepository cardRepository;
    private final CardCacheRepository cardCacheRepository;
    private final Mapper mapper;

    @Autowired
    public PriceSearchService(ScryfallService scryfallService, StoreScraperService storeScraperService, ListingRepository listingRepository, CardRepository cardRepository, CardCacheRepository cardCacheRepository, Mapper mapper) {
        this.scryfallService = scryfallService;
        this.storeScraperService = storeScraperService;
        this.listingRepository = listingRepository;
        this.cardRepository = cardRepository;
        this.cardCacheRepository = cardCacheRepository;
        this.mapper = mapper;
    }

    public List<ListingDto> getCardPriceByFilters(String cardName) {
        List<ListingDto> listingResults = new ArrayList<>();
        // if exists in cache just fetch from db
        if (this.cardCacheRepository.existsByName(cardName)) {
            // fetch listing from db by card info? hmm

        } else {
            // fetch card information from scryfall if not in cache
            CardDto searchCard = this.scryfallService.getCardData(cardName);
            CardCache cachedCard = new CardCache();
            cachedCard.setName(cardName);
            cachedCard.setOracleId(searchCard.getOracleId());
            this.cardCacheRepository.save(cachedCard);
            this.cardRepository.save(this.mapper.cardToEntity(searchCard));
            // else fetch from scraper service and save in db and cache
            storeScraperService.getCardPriceByName(cardName).forEach(listing -> {
                Card listingCard = listing.getCard();
                if (listingCard.getCardName().equals(cardName)) {
                    this.listingRepository.save(listing);
                    listingResults.add(this.mapper.listingToDto(listing));
                }
            });
        }
        return listingResults;
    }
}
