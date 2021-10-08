package springframework.petclinic.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "visit")
public class Visit extends BaseEntity{

    private LocalDate date;


    private  String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
