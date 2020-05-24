package gepeng18.test.数据结构.排序;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class 客户化排序 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Person && o2 instanceof Person)
            return ((Person)o2).age - ((Person)o1).age;
        else
            //随便排吧
            return 0;
    }

    @AllArgsConstructor
    static class Person {
        int age;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>(new 客户化排序());
        treeSet.add(new Person(9));
        treeSet.add(new Person(1));
        treeSet.add(new Person(14));

        Iterator<Person> iterator = treeSet.iterator();

        while (iterator.hasNext()){
            final Person person = iterator.next();
            System.out.println(person);
        }
    }
}
