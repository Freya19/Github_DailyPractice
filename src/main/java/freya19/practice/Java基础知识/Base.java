package freya19.practice.Java基础知识;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class Base  {
    public static final String FOO = "foo";

    public static void main(String[] args) {
        Base b = new Base();

        new HashSet<Integer>();

        new ConcurrentHashMap<>();

    }

    class Sub extends Base{
        public  static final String FOO="bar";
    }
}



