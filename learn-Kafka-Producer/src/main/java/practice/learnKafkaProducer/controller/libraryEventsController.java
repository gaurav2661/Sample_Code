package practice.learnKafkaProducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.learnKafkaProducer.domain.Book;
import practice.learnKafkaProducer.domain.LibraryEventType;
import practice.learnKafkaProducer.producer.LibraryEventProducer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class libraryEventsController {

    @Autowired
    LibraryEventProducer libraryEventProducer;

    @GetMapping("/showDummy")
    public LibraryEvent sendDummyEvent(){
        Book book1 = Book.builder().bookName("jaba")
                .bookAuthor("gaurav")
                .bookPublisher("mcgrawHill")
                .ISBN("IDKJGF8985JHVJF")
                .build();
        return LibraryEvent.builder().libraryEventId(123)
                .book(book1).build();
    }
    @PostMapping("/createEvent")
    public ResponseEntity<LibraryEvent> createLibraryEvent(@RequestBody LibraryEvent libraryEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
        //invoke kafka producer

        //libraryEventProducer.sendLibraryEvent(libraryEvent);
        log.info("before sending");
       // SendResult<Integer,String> stringSendResult = libraryEventProducer.libraryEvent_synchronous(libraryEvent);
        //log.info("send result is : {} ",stringSendResult.toString());
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEvent_approach2(libraryEvent);
        log.info("after sending");

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
    @PutMapping("/updateEvent")
    public ResponseEntity<?> updateLibraryEvent(@RequestBody LibraryEvent libraryEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
        //invoke kafka producer
        if(libraryEvent.getLibraryEventId()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please provide a id");
        }
        //libraryEventProducer.sendLibraryEvent(libraryEvent);
        log.info("before sending");
        // SendResult<Integer,String> stringSendResult = libraryEventProducer.libraryEvent_synchronous(libraryEvent);
        //log.info("send result is : {} ",stringSendResult.toString());
        libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
        libraryEventProducer.sendLibraryEvent_approach2(libraryEvent);
        log.info("after sending");

        return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);
    }
}
