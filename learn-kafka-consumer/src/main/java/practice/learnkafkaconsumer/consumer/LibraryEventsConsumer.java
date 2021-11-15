package practice.learnkafkaconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import practice.learnkafkaconsumer.service.LibraryEventService;

@Component
@Slf4j
public class LibraryEventsConsumer {
    @Autowired
    LibraryEventService libraryEventService;

    @KafkaListener(topics = {"library-event"})
    public void onMessage(ConsumerRecord<Integer,String > consumerRecord)
            throws JsonProcessingException {
        log.info("Consumer Record:{}",consumerRecord);

        libraryEventService.processLibraryEvent(consumerRecord);

    }
}
