package com.shizubro.mtgmarket.model;

import com.shizubro.mtgmarket.model.enums.CARDCONDITION;
import com.shizubro.mtgmarket.model.enums.CARDLANG;
import com.shizubro.mtgmarket.model.enums.CARDSHOP;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class ListingDTO {
    // source
    private CARDSHOP source;
    // card name
    private String cardName;
    // card language
    private CARDLANG lang;
    // foiling
    private boolean isFoil;
    // listing_url
    private String listingUrl;
    // price
    private BigInteger price;
    // condition
    private CARDCONDITION condition;
    // card image url
    private String cardImageUrl;
}
