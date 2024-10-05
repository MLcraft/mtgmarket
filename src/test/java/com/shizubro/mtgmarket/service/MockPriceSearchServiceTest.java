package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.cache.CardCache;
import com.shizubro.mtgmarket.cache.CardCacheRepository;
import com.shizubro.mtgmarket.mapper.Mapper;
import com.shizubro.mtgmarket.model.Card;
import com.shizubro.mtgmarket.repository.CardRepository;
import com.shizubro.mtgmarket.repository.ListingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;


@SpringBootTest(classes = MockPriceSearchService.class)
public class MockPriceSearchServiceTest {
    // mock redis cardcache

    @Autowired
    private MockPriceSearchService mockPriceSearchService;

    @MockBean
    private Mapper mockMapper;

    @MockBean
    private CardCacheRepository mockCardCacheRepository;
    @MockBean
    private CardRepository mockCardRepository;
    @MockBean
    private ListingRepository mockListingRepository;

    @BeforeEach
    public void setUp() {
        mockMapper = Mockito.mock(Mapper.class);
        mockCardCacheRepository = Mockito.mock(CardCacheRepository.class);
        mockCardRepository = Mockito.mock(CardRepository.class);
        mockPriceSearchService = new MockPriceSearchService(mockListingRepository, mockCardRepository, mockCardCacheRepository, mockMapper);
    }
    @Test
    public void cacheNotExistsTest() {



        //Whatever asserts need to be done on the object myObject
    }

    @Test
    public void cacheExistsTest() {

        Mockito.when(mockCardCacheRepository.existsByName("TestName")).thenReturn(true);
        CardCache cache = new CardCache();
        UUID testOracleId = UUID.randomUUID();
        cache.setName("TestName");
        cache.setOracleId(testOracleId);
        Mockito.when(mockCardCacheRepository.findByName("TestName")).thenReturn(cache);
        Card card = new Card();
        card.setCardName("TestName");
        card.setOracleId(testOracleId);
        Mockito.when(mockCardRepository.findById(testOracleId)).thenReturn(Optional.of(card));

        this.mockPriceSearchService.getCardPriceByFilters("TestName");

        Mockito.verify(mockCardCacheRepository, Mockito.times(1)).existsByName("TestName");
        Mockito.verify(mockCardCacheRepository, Mockito.times(1)).findByName("TestName");
        Mockito.verify(mockCardRepository, Mockito.times(1)).findById(testOracleId);
        //Whatever asserts need to be done on the object myObject
    }
}
