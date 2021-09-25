package springframework.sfgdi.pets;

public class PetServiceFactory {
    public Petservice getPetService(String PetType) {
        switch (PetType) {
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }
}
