package practice.learnkafkaconsumer.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class LibraryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer libraryEventId;
    @OneToOne(mappedBy = "libraryEvent",cascade = {CascadeType.ALL})
    @ToString.Exclude
    private Book book;
    @Enumerated(EnumType.STRING)
    private LibraryEventType libraryEventType;
}
