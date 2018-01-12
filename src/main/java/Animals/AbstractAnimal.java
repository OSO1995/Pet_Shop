package Animals;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected String character;
    protected Integer cost;

    protected Integer degreeOfPollution;

    public AbstractAnimal(String name, String breed, String character, String cost, String degreeOfPollution) {
        this.name = name;
        this.breed = breed;
        this.character = character;
        this.cost = Integer.parseInt(cost);
        this.degreeOfPollution = Integer.parseInt(degreeOfPollution);
    }

    protected AbstractAnimal() {
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public Integer getCost() {
        return this.cost;
    }

    @Override
    public Integer getDegreeOfPollution() {
        return this.degreeOfPollution;
    }

    @Override
    public void setDegreeOfPollution(int i) {
        if ((i < -30 || i > -20) || (i > 30 || i < 20)) {
            if ((this.degreeOfPollution + i) > 0) {
                this.degreeOfPollution += i;
            } else {
                this.degreeOfPollution = 0;
            }
        } else {
            throw new IllegalArgumentException("Некорректное значение загрязнения/очистки!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractAnimal that = (AbstractAnimal) o;

        if (breed != null ? !breed.equals(that.breed) : that.breed != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (character != null ? !character.equals(that.character) : that.character != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        return degreeOfPollution != null ? degreeOfPollution.equals(that.degreeOfPollution) : that.degreeOfPollution == null;
    }

    @Override
    public int hashCode() {
        int result = breed != null ? breed.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (character != null ? character.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (degreeOfPollution != null ? degreeOfPollution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + breed + " " + character + " " + cost.toString() + " " + degreeOfPollution.toString();
    }
}
