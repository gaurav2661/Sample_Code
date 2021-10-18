package springframework.petclinic.services.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.Model.Pet;
import springframework.petclinic.services.OwnerService;
import springframework.petclinic.services.PetService;
import springframework.petclinic.services.petTypeService;

import java.util.List;
import java.util.Objects;
import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner , Long> implements OwnerService {
    private final petTypeService pettypeService;
    private final PetService petService;




    public OwnerServiceMap(petTypeService pettypeService, PetService petService) {
        this.pettypeService = pettypeService;
        this.petService = petService;


    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet->{
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(pettypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("pet type is required");
                    }if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object.getId(),object);
        }
        else
            return null;

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> owners =super.findAll();
        for(Owner owner:owners){
            if(Objects.equals(owner.getLastName(), lastName)){
                return owner;
            }
        }return null;
    }
}
