package com.shizubro.mtgmarket.repository;

import com.shizubro.mtgmarket.model.ScryfallCardData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScryfallCardDataRepository extends JpaRepository<ScryfallCardData, UUID> {
}