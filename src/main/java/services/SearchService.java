package services;

import animals.Animal;
import contexts.Context;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
  private final PetShopStorage petShopStorage = Context.getStorage();

  /**
   * функция для поиска животного
   *
   * @param animal - экземпляр для поиска
   * @return true - если такое животное есть в магазине, false - в противном случае
   */
  public boolean search(Animal animal) {
    return petShopStorage.getAnimals().stream().anyMatch(x -> x.equals(animal));
  }

  private List<Animal> search(String str) {
    List<Animal> result = new ArrayList<>();
    petShopStorage.getAnimals().forEach(x -> searchHelper(x, result, str));
    return result;
  }

  /**
   * функция для поиска животного по 2-м параметрам
   *
   * @param x - первый параметр
   * @param y - второй параметр
   * @return список животных подходящих по описанию
   */
  public List<Animal> search(String x, String y) {
    List<Animal> tmp = search(x);
    return search(y, tmp);
  }

  /**
   * функция для поиска животного по 2-м параметрам
   *
   * @param x - первый параметр
   * @param y - второй параметр
   * @param z - третий параметр
   * @return список животных подходящих по описанию
   */
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

  /**
   * функция для поиска животного по 2-м параметрам
   *
   * @param str  - строчный параметр
   * @param cost - цена
   * @return список животных подходящих по описанию
   */
  public List<Animal> search(String str, int cost) {
    List<Animal> tmp = search(cost);
    return search(str, tmp);
  }

  /**
   * функция для поиска животного по 2-м параметрам
   *
   * @param x    - первый параметр
   * @param y    - второй параметр
   * @param cost - цена
   * @return список животных подходящих по описанию
   */
  public List<Animal> search(String x, String y, int cost) {
    List<Animal> tmp = search(cost);
    tmp = search(x, tmp);
    return search(y, tmp);
  }

  /**
   * функция для поиска животного по 2-м параметрам
   *
   * @param x    - первый параметр
   * @param y    - второй параметр
   * @param z    - третий параметр
   * @param cost - цена
   * @return список животных подходящих по описанию
   */
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
