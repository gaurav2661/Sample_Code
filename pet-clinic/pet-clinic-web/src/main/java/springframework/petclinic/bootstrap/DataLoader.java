package springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.petclinic.Model.Owner;
import springframework.petclinic.Model.Vet;
import springframework.petclinic.services.OwnerService;
import springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("paramjit");
        owner1.setLastName("son");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("jimmy");
        owner2.setLastName("sherill");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("diljit");
        owner3.setLastName("dosanjh");
        ownerService.save(owner3);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("katrina");
        vet1.setId(12L);
        vet1.setLastName("kaif");
        vetService.save(vet1);

        Vet vet3 = new Vet();
        vet3.setFirstName("kylie");
        vet3.setId(15L);
        vet3.setLastName("jenner");
        vetService.save(vet3);

        Vet vet2 = new Vet();
        vet2.setFirstName("priyanka");
        vet2.setId(13L);
        vet2.setLastName("chopra");
        System.out.println("loaded vets...");
        vetService.save(vet2);

    }
}
