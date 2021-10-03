package springframework.petclinic.services.SpringJpaData;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Speciality;
import springframework.petclinic.repositories.SpecialityRepository;
import springframework.petclinic.services.SpecialitiesService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialitiesService {
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return null;
    }

    @Override
    public Speciality save(Speciality object) {
        return null;
    }

    @Override
    public void delete(Speciality object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
