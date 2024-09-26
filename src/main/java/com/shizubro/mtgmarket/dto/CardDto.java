package com.shizubro.mtgmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CardDto {
    private UUID oracleId;
    private String cardName;
}
