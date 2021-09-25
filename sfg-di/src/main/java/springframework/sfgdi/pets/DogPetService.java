package springframework.sfgdi.pets;

public class DogPetService implements Petservice{
    @Override
    public String getPetType() {
        return "Dogs are the best";
    }
}
