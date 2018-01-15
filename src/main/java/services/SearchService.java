package services;

import animals.Animal;
import contexts.Context;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
  private final PetShopStorage petShopStorage = Context.getStorage();

  public boolean search(Animal animal) {
    return petShopStorage.getAnimals().stream().anyMatch(x -> x.equals(animal));
  }

  private List<Animal> search(String str) {
    List<Animal> result = new ArrayList<>();
    petShopStorage.getAnimals().forEach(x -> searchHelper(x, result, str));
    return result;
  }

  public List<Animal> search(String x, String y) {
    List<Animal> tmp = search(x);
    return search(y, tmp);
  }

  public List<Animal> search(String x, String y, String z) {
    List<Animal> tmp = search(x);
    tmp = search(y, tmp);
    return search(z, tmp);
  }

  private List<Animal> search(int cost) {
    List<Animal> result = new ArrayList<>();
    petShopStorage.getAnimals().forEach(x ->
    {
      if (x.getCost() == cost) {
        result.add(x);
      }
    });
    return result;
  }

  public List<Animal> search(String str, int cost) {
    List<Animal> tmp = search(cost);
    return search(str, tmp);
  }

  public List<Animal> search(String x, String y, int cost) {
    List<Animal> tmp = search(cost);
    tmp = search(x, tmp);
    return search(y, tmp);
  }

  public List<Animal> search(String x, String y, String z, int cost) {
    List<Animal> tmp = search(cost);
    tmp = search(x, tmp);
    tmp = search(y, tmp);
    return search(z, tmp);
  }

  private void searchHelper(Animal x, List<Animal> result, String str) {
    if (x.getName().equals(str)) {
      result.add(x);
    } else if (x.getBreed().equals(str)) {
      result.add(x);
    } else if (x.getCharacter().equals(str))
      result.add(x);
  }


  private List<Animal> search(String str, List<Animal> animals) {
    List<Animal> result = new ArrayList<>();
    animals.forEach(x -> searchHelper(x, result, str));
    return result;
  }
}
