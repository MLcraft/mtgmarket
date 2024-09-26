package com.shizubro.mtgmarket.mapper;

import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.dto.ListingDto;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class CardMapper {

    public CardDto toDto(Card card) {
        String cardName = card.getCardName();
        UUID oracleId = card.getOracleId();
        return new CardDto(oracleId, cardName);
    }

    public Card toEntity(CardDto cardDto) {

        Card card = new Card();
        card.setCardName(cardDto.getCardName());
        card.setOracleId(cardDto.getOracleId());
        return card;
    }

}
