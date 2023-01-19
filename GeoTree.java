import java.util.ArrayList;
/**
    * выделяем сущность "Генеалогическое древо": говорим класс GeoTree,
     для этой сущности определено  поле - tree, которое явл ArrayList с
     узлами Node, те древо - это список отношений между людьми
*/
public class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();
    /**
     * Метод получения древа (поле private)
     * @return
     */
    public ArrayList<Node> getTree() {
        return tree;
    }
    /**
     * Метод добавления узлов принимает  
     * родителя и ребенка и добавляет два узла отношений 
     * м-ду ними: родитель- ребенок и ребенок- родитель
     * @param parent
     * @param children
     */
    public void appendParentChildShip(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children)); 
        //в список узлов tree добавляется новый Node родитель - отношение родитель- ребенок
        tree.add(new Node(children, Relationship.children, parent));
        //в список узлов tree добавляется новый Node ребенок - отношение ребенок- родитель
    }
    public void appendWifeHusbandShip(Person wife, Person husband) {
        tree.add(new Node(wife, Relationship.wife, husband)); 
        //в список узлов tree добавляется новый Node жена - отношение жена- муж
        tree.add(new Node(husband, Relationship.husband, wife));
        //в список узлов tree добавляется новый Node муж - отношение муж- жена
    }
}