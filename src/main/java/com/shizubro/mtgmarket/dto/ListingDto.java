package com.shizubro.mtgmarket.dto;

import com.shizubro.mtgmarket.enums.CARDCONDITION;
import com.shizubro.mtgmarket.enums.CARDLANG;
import com.shizubro.mtgmarket.enums.CARDSHOP;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class ListingDto {
    private CardDto card;
    private CARDSHOP source;
    private CARDLANG lang;
    private String setCode;
    private String cardNumber;
    private boolean isFoil;
    private String listingUrl;
    private BigInteger price;
    private CARDCONDITION condition;
    private String cardImageUrl;
}
