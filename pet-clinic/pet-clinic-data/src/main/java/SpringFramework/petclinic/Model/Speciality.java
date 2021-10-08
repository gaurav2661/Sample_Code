package springframework.petclinic.Model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "Specialities")
public class Speciality extends BaseEntity {

    //@Column(name = "description")
    private String description;

}
