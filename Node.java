/**
 * Узловой класс, связка между человеком p1, человеком p2 и отношением м-ду ними
 */
public class Node {
  /**
   * Конструктор связывает человека p1, человека p2 и отношение м-ду ними
   * @param p1
   * @param re
   * @param p2
   */
  public Node(Person p1, Relationship re, Person p2) {
      this.p1 = p1;
      this.re = re;
      this.p2 = p2;
  }

  /**
   * Для сущности Node определены  поля - человек p1, человек p2 и отношение м-ду ними re
   */
  Person p1;
  Relationship re;
  Person p2;

  /**
   * переопределили(перегрузка) поведение строки
   */
  @Override
  public String toString() {
      return String.format("<%s %s %s>", p1, re, p2);
  }

}