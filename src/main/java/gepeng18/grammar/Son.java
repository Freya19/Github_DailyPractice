package gepeng18.grammar;

class Parent{
    public int i = 0;
}
public class Son extends Parent{
    public int i = 1;

    public static void main(String[] args) {
        Parent parent = new Son();
        System.out.println(parent.i);
    }
}
