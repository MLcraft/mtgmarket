package com.shizubro.mtgmarket.mapper;

import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.dto.ListingDto;
import com.shizubro.mtgmarket.enums.CARDCONDITION;
import com.shizubro.mtgmarket.enums.CARDLANG;
import com.shizubro.mtgmarket.enums.CARDSHOP;
import com.shizubro.mtgmarket.model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ListingMapper {
    @Autowired
    private CardMapper cardMapper;

    public ListingDto toDto(Listing listing) {
        CardDto cardDto = cardMapper.toDto(listing.getCard());
        CARDSHOP source = listing.getSource();
        CARDLANG lang = listing.getLang();
        String setCode = listing.getSetCode();
        String cardNumber = listing.getCardNumber();
        boolean isFoil = listing.isFoil();
        String listingUrl = listing.getListingUrl();
        BigInteger price = listing.getPrice();
        CARDCONDITION condition = listing.getCondition();
        String cardImageUrl = listing.getCardImageUrl();
        return new ListingDto(cardDto, source, lang, setCode, cardNumber, isFoil, listingUrl, price, condition, cardImageUrl);
    }

    public Listing toEntity(ListingDto listingDto) {
        Listing listing = new Listing();
        listing.setCard(cardMapper.toEntity(listingDto.getCard()));
        return listing;
    }
}
