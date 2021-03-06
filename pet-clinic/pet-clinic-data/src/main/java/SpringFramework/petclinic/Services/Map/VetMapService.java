package springframework.petclinic.services.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Speciality;
import springframework.petclinic.Model.Vet;
import springframework.petclinic.services.SpecialitiesService;
import springframework.petclinic.services.VetService;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialitiesService specialitiesService;

    public VetMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(specialities -> {
                if(specialities.getId()==null){
                    Speciality savedSpeciality = specialitiesService.save(specialities);
                    specialities.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
