package com.shizubro.mtgmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.shizubro.mtgmarket.model.ScryfallCardData}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScryfallCardDataDto implements Serializable {
    private UUID id;

    private String cardName;

    private String cardImageUrl;
}