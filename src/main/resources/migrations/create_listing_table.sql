CREATE TABLE IF NOT EXISTS listing (
  id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   card_id UUID NOT NULL,
   source VARCHAR(255) NOT NULL,
   lang SMALLINT NOT NULL,
   set_code VARCHAR(255) NOT NULL,
   card_number VARCHAR(255) NOT NULL,
   is_foil BOOLEAN NOT NULL,
   listing_url VARCHAR(255) NOT NULL,
   price DECIMAL NOT NULL,
   condition VARCHAR(255) NOT NULL,
   image_url VARCHAR(255) NOT NULL,
   updated_at TIMESTAMP,
   created_at TIMESTAMP,
   CONSTRAINT pk_listings PRIMARY KEY (id)
);

ALTER TABLE listing ADD CONSTRAINT FK_LISTING_ON_CARD FOREIGN KEY (card_id) REFERENCES card (oracle_id);