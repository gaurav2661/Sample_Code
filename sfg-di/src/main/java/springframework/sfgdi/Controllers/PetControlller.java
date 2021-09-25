package springframework.sfgdi.Controllers;

import org.springframework.stereotype.Controller;
import springframework.sfgdi.pets.Petservice;

@Controller
public class PetControlller {
    public final Petservice petservice;

    public PetControlller(Petservice petservice) {
        this.petservice = petservice;
    }
    public String whichPetIsTheBest(){
        return petservice.getPetType();
    }
}
