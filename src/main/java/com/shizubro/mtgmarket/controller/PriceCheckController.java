package com.shizubro.mtgmarket.controller;

import com.shizubro.mtgmarket.model.CardDTO;
import com.shizubro.mtgmarket.model.ListingDTO;
import com.shizubro.mtgmarket.service.MockPriceSearchService;
import com.shizubro.mtgmarket.service.PriceSearchService;
import com.shizubro.mtgmarket.service.ScryfallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/")
public class PriceCheckController {
    @Autowired
    MockPriceSearchService priceSearchService;
//    PriceSearchService priceSearchService;

    @Autowired
    ScryfallService scryfallService;

    // search for all prices for cardName
    @GetMapping("/search/{cardName}")
    public Set<ListingDTO> getListingsByName(@PathVariable String cardName) {
        try {
            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {
            return Set.of();
        }
        return priceSearchService.getCardPriceByFilters(cardName);
    }

    // get printings information for cardName for FE to do filtering on price results
    @GetMapping("/printings/{cardName}")
    public Set<CardDTO> getPrintingsByName(@PathVariable String cardName) {
        return scryfallService.getCardPrintingsByName(cardName);
    }
}
