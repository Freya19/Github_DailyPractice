package gepeng18.test.数据结构.排序;

import lombok.AllArgsConstructor;

import java.sql.SQLOutput;
import java.util.TreeSet;

public class 自然排序 {
    @AllArgsConstructor
    static class Person implements Comparable{
        int age;

        @Override
        /**
         * 从大到小排
         */
        public int compareTo(Object o) {
            if(o instanceof Person)
                return  ((Person)o).age - this.age;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person(9));
        treeSet.add(new Person(1));
        treeSet.add(new Person(14));
        System.out.println(treeSet);
    }
}
