package practice.learnkafkaconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.learnkafkaconsumer.entity.LibraryEvent;
import practice.learnkafkaconsumer.repo.LibraryEventRepo;

@Service
@Slf4j
public class LibraryEventService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LibraryEventRepo libraryEventRepo;
    public void processLibraryEvent(ConsumerRecord<Integer,String> consumerRecord)
            throws JsonProcessingException {


        LibraryEvent libraryEvent = objectMapper.readValue(consumerRecord.value(), LibraryEvent.class);
       log.info(libraryEvent.toString());

        switch(libraryEvent.getLibraryEventType()){
            case NEW:
                //save event
                save(libraryEvent);
            case UPDATE:
                //update event
            default:
                log.info("invalid library event type");
        }
    }

    private void save(LibraryEvent libraryEvent) {
        libraryEvent.getBook().setLibraryEvent(libraryEvent);
        libraryEventRepo.save(libraryEvent);
        log.info("Successfully saved library event :{} ",libraryEvent);
    }

}
