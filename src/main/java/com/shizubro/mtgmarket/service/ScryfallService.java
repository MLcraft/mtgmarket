package com.shizubro.mtgmarket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shizubro.mtgmarket.config.ExternalAPIConfig;
import com.shizubro.mtgmarket.dto.CardDto;
import com.shizubro.mtgmarket.dto.ScryfallCardDataDto;
import com.shizubro.mtgmarket.mapper.Mapper;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.model.ScryfallCardData;
import com.shizubro.mtgmarket.repository.ScryfallCardDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("scryfallService")
public class ScryfallService {
    private final ObjectMapper objectMapper;
    private final Mapper mapper;
    private final ScryfallCardDataRepository scryfallCardDataRepository;
    private static final Logger log = LoggerFactory.getLogger(ScryfallService.class);
    private final ExternalAPIConfig apiConfig;
    private HttpClient httpClient = HttpClient.newBuilder().build();

    @Autowired
    public ScryfallService(ObjectMapper objectMapper, ExternalAPIConfig apiConfig, Mapper mapper, ScryfallCardDataRepository scryfallCardDataRepository) {
        this.objectMapper = objectMapper;
        this.apiConfig = apiConfig;
        this.mapper = mapper;
        this.scryfallCardDataRepository = scryfallCardDataRepository;
    }

    // get card data from scryfall
    public CardDto getCardData(String cardName) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(apiConfig.getScryfall() + "/cards/named?exact=" + cardName))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:130.0) Gecko/20100101 Firefox/130.0")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,*/*;q=0.8")
                    .GET()
                    .build();
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(String.valueOf(response.body()));
            CardDto cardData = this.objectMapper.readValue(response.body(), CardDto.class);
            return cardData;
        } catch (IOException | InterruptedException | URISyntaxException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void processCardPrintingData(ScryfallCardDataDto cardPrintingData) {
        ScryfallCardData cardPrintingEntity = this.mapper.scryfallDataToEntity(cardPrintingData);
        this.scryfallCardDataRepository.save(cardPrintingEntity);
    }

    // get card image url from scryfall
    public Set<Card> getCardImage(String cardName, String cardSetCode, String cardNumber) {
        return Set.of();
    }
}
