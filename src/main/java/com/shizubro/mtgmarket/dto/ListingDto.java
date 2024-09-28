package com.shizubro.mtgmarket.dto;

import com.shizubro.mtgmarket.enums.CardCondition;
import com.shizubro.mtgmarket.enums.CardLang;
import com.shizubro.mtgmarket.enums.CardShop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class ListingDto {
    private CardDto card;
    private CardShop source;
    private CardLang lang;
    private String setCode;
    private String cardNumber;
    private boolean isFoil;
    private String listingUrl;
    private BigInteger price;
    private CardCondition condition;
    private String cardImageUrl;
}
