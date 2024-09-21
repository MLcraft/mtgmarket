package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.model.ListingDTO;
import com.shizubro.mtgmarket.model.enums.CARDCONDITION;
import com.shizubro.mtgmarket.model.enums.CARDLANG;
import com.shizubro.mtgmarket.model.enums.CARDSHOP;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Component("mockPriceSearchService")
public class MockPriceSearchService {
    public Set<ListingDTO> getCardPriceByFilters(String cardName) {
        Set<ListingDTO> resultSet = new HashSet<ListingDTO>();
        ListingDTO mockListing1 = ListingDTO.builder()
                .source(CARDSHOP.SERRA)
                .cardName(cardName)
                .lang(CARDLANG.EN)
                .isFoil(false)
                .listingUrl("listingUrl1")
                .price(BigInteger.valueOf(100))
                .condition(CARDCONDITION.SP)
                .cardImageUrl("https://cards.scryfall.io/png/front/f/5/f5a65d3b-83e7-4f32-89b3-d152e66f1868.png?1568005526")
                .build();

        ListingDTO mockListing2 = ListingDTO.builder()
                .source(CARDSHOP.HARERUYA)
                .cardName(cardName)
                .lang(CARDLANG.JP)
                .isFoil(true)
                .listingUrl("listingUrl2")
                .price(BigInteger.valueOf(123100))
                .condition(CARDCONDITION.NM)
                .cardImageUrl("https://cards.scryfall.io/png/front/9/6/96e5358a-23b6-4dac-893e-48f4481609ab.png?1696636954")
                .build();

        resultSet.add(mockListing1);
        resultSet.add(mockListing2);
        return resultSet;
    }
}
