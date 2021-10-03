package springframework.petclinic.services;

import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);


}
