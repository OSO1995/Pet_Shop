package animals;

public interface Animal {

  /**
   * Функция получения породы зверя
   *
   * @return возвращает породу зверя
   */
  String getBreed();

  /**
   * Функция получения имени зверя
   *
   * @return возвращает имя зверя
   */
  String getName();

  /**
   * Функция получения имени зверя
   *
   * @return возвращает имя зверя
   */
  String getCharacter();

  /**
   * Функция получения цены зверя
   *
   * @return возвращает цену зверя
   */
  Integer getCost();

  /**
   * Функция получения степени чистоты зверя
   *
   * @return возвращает степень чистоты зверя
   */
  Integer getDegreeOfPollution();

  /**
   * функция увеличивающая загрязнение зверя на определенное кол-во едениц
   *
   * @param i - случайное значение в диапазоне от 20 до 30
   */
  void setDegreeOfPollution(int i);
}
