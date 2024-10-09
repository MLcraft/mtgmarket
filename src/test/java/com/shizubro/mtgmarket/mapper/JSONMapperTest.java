package com.shizubro.mtgmarket.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shizubro.mtgmarket.dto.ScryfallCardDataDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

public class JSONMapperTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void testJSONtoObject() throws IOException {
        String testData = """
                {
                    "name": "Static Orb",
                    "id": "86bf43b1-8d4e-4759-bb2d-0b2e03ba7012",
                    "image_uri": "https://cards.scryfall.io/large/front/8/6/86bf43b1-8d4e-4759-bb2d-0b2e03ba7012.jpg?1562242171"
                }
                """;
        ScryfallCardDataDto convertedData = this.mapper.readValue(testData, ScryfallCardDataDto.class);
        Assertions.assertInstanceOf(ScryfallCardDataDto.class, convertedData);
        Assertions.assertEquals("Static Orb", convertedData.getCardName());
        Assertions.assertEquals(0, convertedData.getId().compareTo(UUID.fromString("86bf43b1-8d4e-4759-bb2d-0b2e03ba7012")));
        Assertions.assertEquals("https://cards.scryfall.io/large/front/8/6/86bf43b1-8d4e-4759-bb2d-0b2e03ba7012.jpg?1562242171", convertedData.getCardImageUrl());
    }
}
