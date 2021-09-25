package springframework.petclinic.services.Map;

import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Specialities;
import springframework.petclinic.services.SpecialitiesService;

import java.util.Set;
@Service
public class SpecialityMapService extends AbstractMapService<Specialities,Long>implements SpecialitiesService {
    @Override
    public Set<Specialities> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialities object) {
        super.delete(object);
    }

    @Override
    public Specialities save(Specialities object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Specialities findById(Long id) {
        return super.findById(id);
    }
}
