package com.shizubro.mtgmarket.dto;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.shizubro.mtgmarket.model.Card}
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CardDto implements Serializable {
    private UUID oracleId;
    private String cardName;
}