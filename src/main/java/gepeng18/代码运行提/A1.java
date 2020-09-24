package gepeng18.代码运行提;

public class A1 {
    public static void main(String[] args) {
        float a = 0;
        int b = 0;
        System.out.println(a == b);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10000000; j++) {
                a++;
                b++;
            }
            System.out.println(a==b);
        }
    }
}
