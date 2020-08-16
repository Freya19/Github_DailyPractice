package freya19.practice.Java基础知识;

import java.util.ArrayList;

class A {
    protected int i = 0;
}

class B extends A{
    public void fun(){
        System.out.println(i);
    }
}
public class 验证泛型检查 {

    public static void main(String[] args) {
        System.out.println(new B().i);
    }
}
