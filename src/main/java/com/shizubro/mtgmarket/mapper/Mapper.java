package com.shizubro.mtgmarket.mapper;

import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.dto.ListingDto;
import com.shizubro.mtgmarket.enums.CARDCONDITION;
import com.shizubro.mtgmarket.enums.CARDLANG;
import com.shizubro.mtgmarket.enums.CARDSHOP;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;

import java.math.BigInteger;
import java.util.UUID;

public class Mapper {
    public ListingDto listingToDto(Listing listing) {
        CardDto cardDto = this.cardToDto(listing.getCard());
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

    public Listing listingToEntity(ListingDto listingDto) {
        Listing listing = new Listing();
        listing.setCard(this.cardToEntity(listingDto.getCard()));
        return listing;
    }

    public CardDto cardToDto(Card card) {
        String cardName = card.getCardName();
        UUID oracleId = card.getOracleId();
        return new CardDto(oracleId, cardName);
    }

    public Card cardToEntity(CardDto cardDto) {
        Card card = new Card();
        card.setCardName(cardDto.getCardName());
        card.setOracleId(cardDto.getOracleId());
        return card;
    }
}
