package practice.learnKafkaProducer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private String bookName;
    private String ISBN;
    private String bookAuthor;
    private String bookPublisher;

}
