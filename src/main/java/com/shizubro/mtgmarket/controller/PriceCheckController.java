package com.shizubro.mtgmarket.controller;

import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;
import com.shizubro.mtgmarket.service.PriceSearchService;
import com.shizubro.mtgmarket.service.ScryfallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/")
public class PriceCheckController {
    @Autowired
//    MockPriceSearchService priceSearchService;
    PriceSearchService priceSearchService;

    @Autowired
    ScryfallService scryfallService;

    // search for all prices for cardName
    @GetMapping("/search/{cardName}")
    public Set<Listing> getListingsByName(@PathVariable String cardName) {
        try {
            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {
            return Set.of();
        }
        return priceSearchService.getCardPriceByFilters(cardName);
    }

    // get printings information for cardName for FE to do filtering on price results
    @GetMapping("/cardinfo/{cardName}")
    public Set<Card> getPrintingsByName(@PathVariable String cardName) throws URISyntaxException, IOException, InterruptedException {
        return scryfallService.getCardData(cardName);
    }
}
