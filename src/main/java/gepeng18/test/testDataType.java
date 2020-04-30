package gepeng18.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class testDataType {
    static class Person{
        int age;
    }

    public static void main(String[] args) {
        final int age = new Person().age;

    }
}
