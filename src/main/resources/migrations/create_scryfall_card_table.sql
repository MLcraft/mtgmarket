CREATE TABLE scryfall_card_data
(
    id         UUID         NOT NULL,
    cardname   VARCHAR(255) NOT NULL,
    imageurl   VARCHAR(255),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_scryfall_card_data PRIMARY KEY (id)
);