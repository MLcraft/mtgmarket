package com.shizubro.mtgmarket.cache;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCacheRepository extends CrudRepository<CardCache, String> {
    boolean existsByName(String name);

    CardCache findByName(String name);
}
