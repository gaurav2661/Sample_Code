package com.learningKafka.kafkaproducer.controller;

import com.learningKafka.kafkaproducer.domain.Book;
import com.learningKafka.kafkaproducer.domain.LibraryEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"library-events"},partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})

class LibraryEventsControllerTestIntegrationTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void postLibraryEvent() {
        //given
        Book book = Book.builder()
                .bookId(1)
                .bookAuthor("gaurva")
                .bookName("java")
                .build();
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .libraryEventId(null)
                .book(book).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<LibraryEvent> entity = new HttpEntity<>(libraryEvent,httpHeaders);

        //when
        ResponseEntity<LibraryEvent> libraryEventResponseEntity =
                testRestTemplate.exchange("/v1/libraryevent", HttpMethod.POST,entity,LibraryEvent.class);

        //then
        assertEquals(HttpStatus.CREATED,libraryEventResponseEntity.getStatusCode());
    }
}