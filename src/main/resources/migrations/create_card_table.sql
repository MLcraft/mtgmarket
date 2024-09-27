CREATE TABLE IF NOT EXISTS card (
  oracle_id UUID NOT NULL,
   cardname VARCHAR(255) NOT NULL,
   updated_at TIMESTAMP,
   created_at TIMESTAMP,
   CONSTRAINT pk_cards PRIMARY KEY (oracle_id)
);