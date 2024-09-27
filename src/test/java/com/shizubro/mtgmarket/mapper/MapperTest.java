package com.shizubro.mtgmarket.mapper;

import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.model.Card;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {
    private Mapper mapper = new Mapper();

    // add more tests for listing mapping

    @Test
    void testCardToDto() {
        Card testCard = new Card();
        UUID cardOracleId = UUID.randomUUID();
        testCard.setOracleId(cardOracleId);
        testCard.setCardName("Test Card Name");

        CardDto mappedCardDto = mapper.cardToDto(testCard);
        assertEquals(cardOracleId, mappedCardDto.getOracleId());
        assertEquals("Test Card Name", mappedCardDto.getCardName());
    }

    @Test
    void testCardToEntity() {
        UUID cardOracleId = UUID.randomUUID();
        CardDto testCardDto = new CardDto(cardOracleId, "Test Card DTO Name");

        Card mappedCard = mapper.cardToEntity(testCardDto);
        assertEquals(cardOracleId, mappedCard.getOracleId());
        assertEquals("Test Card DTO Name", mappedCard.getCardName());
    }
}
