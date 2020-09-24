package gepeng18.代码运行提;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class A3 {
    public static void change(String val){
        val = "1234";
    }
    public static void main(String[] args) {
        String a = "1";
        change(a);
        System.out.println(a);
    }
}
