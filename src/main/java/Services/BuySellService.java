package Services;

import Animals.Animal;
import contexts.context;

public class BuySellService {
    private PetShopStorage petStorage = context.getStorage();
    private SearchService searchService = context.getSearch();
    private int mony = Integer.MAX_VALUE / 2;

    public void buy(Animal animal) {
        if (haveMony(animal.getCost())) {
            petStorage.addAnimals(animal);
            context.printInfo(getClass().getSimpleName() + ": Куплена зверушка: " + animal.getName() + " за " + animal.getCost());
        } else {
            context.printInfo(getClass().getSimpleName() + ": Недостаточно денег");
        }
    }

    public void sell(Animal animal) {
        mony += animal.getCost();
        petStorage.removeAnimals(animal);
        context.printInfo(getClass().getSimpleName() + ": Продана зверушка: " + animal.getName() + " за " + animal.getCost());
    }

    private boolean haveMony(Integer cost) {
        return (mony - cost) > 0 ? true : false;
    }
}
