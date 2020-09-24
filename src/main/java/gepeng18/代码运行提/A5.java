package gepeng18.代码运行提;

class SUper{
    static {
        System.out.println("supper");
    }
}
public class A5 {
    public static void main(String[] args) {
        System.out.println("主函数");
        SUper s = new SUper();

    }
}
