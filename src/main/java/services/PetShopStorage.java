package services;

import animals.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class PetShopStorage {
  private final Set<Animal> animals = new HashSet<>();
  private boolean flagFirstStart = true;

  private void init() {
    if (flagFirstStart) {
      getAnimalFile();
      flagFirstStart = false;
    }
  }

  public List<Animal> getAnimals() {
    init();
    List<Animal> tmp = new ArrayList<Animal>();
    animals.forEach(x -> tmp.add(x));
    return tmp;
  }

  private void getAnimalFile() {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\storage.txt"))) {
      for (String tmp = bufferedReader.readLine(); tmp != null; tmp = bufferedReader.readLine()) {
        Animal animal = restoreAnimal(tmp);
        if (!animals.contains(animal)) {
          addAnimals(restoreAnimal(tmp));
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private Animal restoreAnimal(String tmp) {
    String[] attribursAnimal = tmp.split(" ");
    String[] animalName = attribursAnimal[0].split("-");
    if (animalName[0].equals("Dog")) {
      return new Dog(attribursAnimal[0], attribursAnimal[1], attribursAnimal[2], attribursAnimal[3], attribursAnimal[4]);
    } else if (animalName[0].equals(("Cat"))) {
      return new Cat(attribursAnimal[0], attribursAnimal[1], attribursAnimal[2], attribursAnimal[3], attribursAnimal[4]);
    } else if (animalName[0].equals(("Wolf"))) {
      return new Wolf(attribursAnimal[0], attribursAnimal[1], attribursAnimal[2], attribursAnimal[3], attribursAnimal[4]);
    } else if (animalName[0].equals(("Shark"))) {
      return new Shark(attribursAnimal[0], attribursAnimal[1], attribursAnimal[2], attribursAnimal[3], attribursAnimal[4]);
    } else {
      throw new IllegalArgumentException("Нет такого животного!");
    }
  }

  public void addAnimals(Animal animal) {
    this.animals.add(animal);
  }

  public void removeAnimals(Animal animal) {
    this.animals.remove(animal);
  }
}
