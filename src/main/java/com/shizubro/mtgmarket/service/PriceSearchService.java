package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component("priceSearchService")
public class PriceSearchService {

    @Autowired
    ScryfallService scryfallService;

    @Autowired
    StoreScraperService storeScraperService;

    public Set<Listing> getCardPriceByFilters(String cardName) {
        return storeScraperService.getCardPriceByName(cardName);
    }
}
