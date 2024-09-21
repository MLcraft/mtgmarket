package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.model.CardDTO;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component("scryfallService")
public class ScryfallService {

    // get card printings from scryfall
    public Set<CardDTO> getCardPrintingsByName(String cardName) {
        return Set.of();
    }
}
