package com.learningKafka.kafkaproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learningKafka.kafkaproducer.domain.LibraryEvent;
import com.learningKafka.kafkaproducer.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class LibraryEventsController {
    @Autowired
    LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {

        //invoke kafka producer
       // libraryEventProducer.sendLibraryEvent(libraryEvent);
      // SendResult<Integer,String> result=libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
     // log.info("Send Result is : {}",result.toString());
        libraryEventProducer.sendLibraryEvent_approach2(libraryEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
}
