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
    private Integer id;
    // source
    private CARDSHOP source;
    // card language
    private CARDLANG lang;
    // set code
    private String setCode;
    // card number
    private Integer cardNumber;
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
