package com.shizubro.mtgmarket.dto;

import com.shizubro.mtgmarket.enums.CardCondition;
import com.shizubro.mtgmarket.enums.CardLang;
import com.shizubro.mtgmarket.enums.CardShop;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * DTO for {@link com.shizubro.mtgmarket.model.Listing}
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ListingDto implements Serializable {
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