package Animals;

public abstract class Pet extends AbstractAnimal {
    public Pet(String name, String breed, String character, String cost, String degreeOfPollution) {
        super(name, breed, character, cost, degreeOfPollution);
    }

    protected Pet() {
    }
}
