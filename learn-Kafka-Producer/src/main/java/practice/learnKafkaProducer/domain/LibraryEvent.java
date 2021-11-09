package practice.learnkafkaconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvent {
    private Integer libraryEventId;
    private practice.learnKafkaProducer.domain.Book book;
    private LibraryEventType libraryEventType;
}
