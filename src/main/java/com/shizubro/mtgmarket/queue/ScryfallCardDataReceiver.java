package com.shizubro.mtgmarket.queue;


import com.shizubro.mtgmarket.dto.ScryfallCardDataDto;
import com.shizubro.mtgmarket.service.ScryfallService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

import java.util.function.Consumer;

@Slf4j
@Controller
@Configuration
public class ScryfallCardDataReceiver {

    private final ScryfallService scryfallService;

    @Autowired
    public ScryfallCardDataReceiver(ScryfallService scryfallService) {
        this.scryfallService = scryfallService;
    }

    public void handle(@NotNull final Message<ScryfallCardDataDto> message) {
        log.info("Consume a message from queue");
        scryfallService.processCardPrintingData(message.getPayload());
    }

    @Bean
    public Consumer<Message<ScryfallCardDataDto>> scryfallCardDataMessage() {
        return payload -> handle(payload);
    }
}
