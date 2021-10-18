package springframework.brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import springframework.brewery.web.model.BeerDto;
import springframework.brewery.web.services.BeerService;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class BeerControllerTest {
    @Mock
    BeerService beerService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;
    @BeforeEach
    void setUp() {
        validBeer= BeerDto.builder().id(UUID.randomUUID()).beerStyle("Pale_ale").beerName("beer1").build();
    }

    @Test
    void getBeer() {
    }

    @Test
    void handleUpdateBeer() {
    }
}