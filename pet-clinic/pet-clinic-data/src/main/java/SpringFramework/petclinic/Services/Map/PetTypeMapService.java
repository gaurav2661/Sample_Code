package springframework.petclinic.services.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.petclinic.Model.PetType;
import springframework.petclinic.services.petTypeService;

import java.util.Set;
@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements petTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object.getId(),object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
