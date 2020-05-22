package gepeng18.笔试.模拟考试;

public class Parent extends Base {
    int age;

    public Parent() {
        super();
        System.out.println("parent的构造函数启动了");
    }

    public static void main(String[] args) {
        new Parent();
    }
}
