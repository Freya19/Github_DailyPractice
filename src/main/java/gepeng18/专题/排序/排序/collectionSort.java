package gepeng18.专题.排序.排序;

import lombok.AllArgsConstructor;

import java.util.*;

public class collectionSort {
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
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(9));
        personList.add(new Person(1));
        personList.add(new Person(14));
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1 instanceof Person && o2 instanceof Person)
                    return ((Person)o2).age - ((Person)o1).age;
                else
                    //随便排吧
                    return 0;
            }
        });
        Iterator<Person> iterator = personList.iterator();

        while (iterator.hasNext()){
            final Person person = iterator.next();
            System.out.println(person);
        }
    }
}
