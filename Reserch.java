import java.util.ArrayList;
import java.util.Scanner;
/**
    * выделяем сущность "Исследование": говорим класс Reserch,
     для этой сущности определены  поля - результирующий список result,
     древо tree и searchAge, которые явл ArrayList
*/
public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;
    ArrayList<String> searchAge = new ArrayList<>();
    /**
     * Конструктор сущности Исследование принимает объект GeoTree и 
     * инициализирует древо tree
     * @param geoTree
     */
    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }
    /**
     * Метод возвращает список всех людей в отношении re к человеку р
     * @param p - человек
     * @param re - отношение
     * @return
     */
    public ArrayList<String> spend(Person p, Relationship re) {
        for (Node t : tree) { //бегаем по узлам из дерева
            if (t.p1.fullName == p.fullName && t.re == re) { //достаем атрибуты и сравниваем их
                result.add(t.p2.fullName); //добавляем в результ список
            }
        }
        return result;
    }

    /**
     * Метод возвращает список всех людей, старше введенного возраста
     * @return
     */
    public ArrayList<String> searchAge() {
        System.out.print("Введите возраст, старше кототрого, ищем людей: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("Люди, старше: " + age + ":");

        for (Node t : tree) { //бегаем по узлам из дерева

            if (t.p1.age >= age && !searchAge.contains(t.p1.fullName)) {//достаем атрибуты и сравниваем их
                searchAge.add(t.p1.fullName);//добавляем в результ список
            }
        }
        return searchAge;
    }
}
