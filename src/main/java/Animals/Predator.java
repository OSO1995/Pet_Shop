package Animals;

public abstract class Predator extends AbstractAnimal {
    public Predator(String name, String breed, String character, String cost, String degreeOfPollution) {
        super(name, breed, character, cost, degreeOfPollution);
    }

    protected Predator() {
    }
}
