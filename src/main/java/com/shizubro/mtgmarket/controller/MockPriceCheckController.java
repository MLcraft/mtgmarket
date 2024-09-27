package com.shizubro.mtgmarket.controller;

import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;
import com.shizubro.mtgmarket.service.MockPriceSearchService;
import com.shizubro.mtgmarket.service.ScryfallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping(path = "/mock/")
public class MockPriceCheckController {
    MockPriceSearchService priceSearchService;
    ScryfallService scryfallService;

    @Autowired
    public MockPriceCheckController(MockPriceSearchService mockPriceSearchService,
                                    ScryfallService scryfallService) {
        this.priceSearchService = mockPriceSearchService;
        this.scryfallService = scryfallService;
    }

    // search for all prices for cardName
    @GetMapping("/search/{cardName}")
    public Set<Listing> getListingsByName(@PathVariable String cardName) {
        return priceSearchService.getCardPriceByFilters(cardName);
    }

    // get printings information for cardName for FE to do filtering on price results
    @GetMapping("/cardinfo/{cardName}")
    public Set<Card> getPrintingsByName(@PathVariable String cardName) throws URISyntaxException, IOException, InterruptedException {
        return scryfallService.getCardData(cardName);
    }
}
