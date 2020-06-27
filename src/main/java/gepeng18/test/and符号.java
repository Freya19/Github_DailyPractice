package gepeng18.test;

public class and符号 {
    public static void main(String[] args) {
        String a = null;
        System.out.println(a!=null&&a.equals(""));
        //一个&有逻辑与和按位与的作用，但是不会短路
        System.out.println(a!=null&a.equals(""));
    }
}
