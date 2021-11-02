package springframework.petclinic.services;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
