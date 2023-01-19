/* Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом. 

Идея: описать некоторое количество компонент, например: модель человека компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, 
но можно подумать и про отношение, брат, свекровь, сестра и т. д. 

компонент для проведения исследований дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека 

Под “проведением исследования” можно понимать получение всех детей выбранного человека. 
Описать с ООП стиле, логику взаимодействия объектов реального мира между собой: шкаф-человек. 

Какие члены должны быть у каждого из классов 
(у меня на семинаре студенты пришли к тому, чтобы продумать логику взаимодействия жена разрешает открыть дверцу шкафа мужу, после чего эту дверцу можно открыть) 

Подумать как описать логику взаимодействия человека и домашнего питомца. 
Сценарий: “Человек “зовёт” котика “кис-кис”, котик отзывается. 
Какое ещё взаимодействие может быть? 
Продумать какие проблемы могут возникнуть в том, коде, который они написали. 

Например в первой задаче (с генеалогическим древом) мы можем знать о двух людях, но не знаем в каких “отношениях” они были - двоюродные или троюродные, или мы точно знаем как звали прапрабабушку, но совершенно не знаем прабабушку - как хранить такие связи или что будет если в компоненту обхода передать ссылку на null-дерево. 

У задач нет единственного правильного решения */

public class Main {
  public static void main(String[] args) {
      Person irina = new Person("Ирина", 80);
      Person vasya = new Person("Вася", 60);
      Person marina = new Person("Марина", 55);
      Person masha = new Person("Маша", 36);
      Person jane = new Person("Женя", 35);
      Person ivan = new Person("Ваня", 40);
      Person ruslan = new Person("Руслан", 6);
      Person timur = new Person("Тимур", 3);
      Person elena = new Person("Елена", 37);
      Person denis = new Person("Денис", 37);

      GeoTree gt = new GeoTree();
      gt.appendParentChildShip(irina, vasya);
      gt.appendParentChildShip(irina, masha);
      gt.appendParentChildShip(vasya, jane);
      gt.appendParentChildShip(vasya, ivan);
      gt.appendParentChildShip(marina, jane);
      gt.appendParentChildShip(marina, ivan);
      gt.appendParentChildShip(elena, ruslan);
      gt.appendParentChildShip(elena, timur);
      gt.appendParentChildShip(denis, ruslan);
      gt.appendParentChildShip(denis, timur);
      gt.appendWifeHusbandShip(marina, vasya);
      gt.appendWifeHusbandShip(elena, denis);

      System.out.println(new Reserch(gt).spend(irina,
              Relationship.parent)); 
      System.out.println("Родители Руслана: " + new Reserch(gt).spend(ruslan,
      Relationship.children));
      System.out.println("Родители Жени: " + new Reserch(gt).spend(jane,
      Relationship.children));
      System.out.println(new Reserch(gt).searchAge());
      System.out.println("Жена Дениса: " + new Reserch(gt).spend(denis, Relationship.husband));
  
  }

}