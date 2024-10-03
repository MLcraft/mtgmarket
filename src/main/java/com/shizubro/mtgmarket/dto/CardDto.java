package com.shizubro.mtgmarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CardDto {
    @JsonProperty("oracle_id")
    private UUID oracleId;
    @JsonProperty("name")
    private String cardName;
}
