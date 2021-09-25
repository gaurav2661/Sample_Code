package springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.petclinic.Model.*;
import springframework.petclinic.services.OwnerService;
import springframework.petclinic.services.SpecialitiesService;
import springframework.petclinic.services.VetService;
import springframework.petclinic.services.petTypeService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final petTypeService pettypeService;
    private final SpecialitiesService specialitiesService;
    private int count;

    public DataLoader(OwnerService ownerService, VetService vetService, petTypeService petTypeService, petTypeService pettypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;

        this.pettypeService = pettypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
       int count = pettypeService.findAll().size();
        if(count ==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = pettypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = pettypeService.save(cat);

        Specialities radiology = new Specialities();
        radiology.setDescription("Radiology");
        Specialities savedRadiology = specialitiesService.save(radiology);

        Specialities surgery = new Specialities();
        surgery.setDescription("Surgery");
        Specialities savedSurgery = specialitiesService.save(surgery);


        Specialities dentistry = new Specialities();
        dentistry.setDescription("Dentistry");
        Specialities savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("paramjit");
        owner1.setLastName("son");

        owner1.setAddress("171 fafa asc london");
        owner1.setCity("california");
        owner1.setTelephone("8989876545");

        Pet paramPet = new Pet();
        paramPet.setPetType(saveCatPetType);
        paramPet.setOwner(owner1);
        paramPet.setBirthDate(LocalDate.now());
        paramPet.setName("CATTY");
        owner1.getPets().add(paramPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("jimmy");
        owner2.setLastName("sherill");
        owner2.setAddress("171 boh asc london");
        owner2.setCity("ottawa");
        owner2.setTelephone("8899096545");

        Pet jimmyPet = new Pet();
        jimmyPet.setPetType(saveDogPetType);
        jimmyPet.setOwner(owner2);
        jimmyPet.setBirthDate(LocalDate.now());
        jimmyPet.setName("DOGGO");
        owner1.getPets().add(jimmyPet);
        ownerService.save(owner2);


        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("katrina");
        vet1.setId(12L);
        vet1.setLastName("kaif");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("priyanka");
        vet2.setId(13L);
        vet2.setLastName("chopra");
        vet2.getSpecialities().add(surgery);
        System.out.println("loaded vets...");
        vetService.save(vet2);
    }
}
