package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.config.ExternalAPIConfig;
import com.shizubro.mtgmarket.model.Card;
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
import java.util.Set;

@Component("scryfallService")
public class ScryfallService {

    private static final Logger log = LoggerFactory.getLogger(ScryfallService.class);
    @Autowired
    ExternalAPIConfig apiConfig;

    private HttpClient httpClient = HttpClient.newBuilder().build();

    // get card data from scryfall
    public Set<Card> getCardData(String cardName) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(apiConfig.getScryfall() + "/cards/named?exact=" + cardName))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:130.0) Gecko/20100101 Firefox/130.0")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,*/*;q=0.8")
                .GET()
                .build();
        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        log.info(String.valueOf(response.body()));
        return Set.of();
    }

    // get card image url from scryfall
    public Set<Card> getCardImage(String cardName, String cardSetCode, String cardNumber) {
        return Set.of();
    }
}
