package freya19.practice.Java基础知识;


class testAbstractAndInterfaceClass {
    final  int i = 4;
}

public class ab  extends testAbstractAndInterfaceClass{
    final int j = 8;

    public static void main(String[] args) {
        ab a = new ab();
        System.out.println(a.i);
    }

}


