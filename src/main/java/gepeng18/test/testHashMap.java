package gepeng18.test;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

public class testHashMap {
    @Setter
    @AllArgsConstructor
    static class Person{
        int age;
        String name;
    }
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();

//         key = gp;
//         value = 20;
//         map.put(key,value);
//         value = 16;
//         map.get(key);


        Person gp = new Person(1, "gp");
        map.put("123", gp);

        gp.setAge(15);

        Person o = (Person) map.get("123");
        System.out.println(o.age);

    }
}
