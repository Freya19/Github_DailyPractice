package gepeng18.代码运行提;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A2 {
    public static void main(String[] args) throws Exception{
        String s = "abc";
        Field f = s.getClass().getDeclaredField("value");
        f.setAccessible(true);
        char [] value = (char [])f.get(s);
        value[0] = 'c';
        value[2] = 'a';
        System.out.println(s);
        System.out.println("abc");
    }
}
