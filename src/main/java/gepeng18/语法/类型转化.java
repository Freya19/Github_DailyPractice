package gepeng18.语法;


import java.util.Comparator;

public class 类型转化  {
    public static void main(String[] args) {
        String t = "1234";
        char[] chars = t.toCharArray();
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

        };
    }
}
