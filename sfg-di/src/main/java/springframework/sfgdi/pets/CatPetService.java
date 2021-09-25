package springframework.sfgdi.pets;

public class CatPetService implements Petservice {
    @Override
    public String getPetType() {
        return "Cats are the best";
    }
}
