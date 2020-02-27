package gepeng18.grammar;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;

public class 封装{
    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        final C c = new C();
        CloseUtils.close(new IClose[]{a,b,c});
    }
}

class CloseUtils{
    public static void  close(IClose... iClose){
        for (int i = 0; i < iClose.length; i++) {
            iClose[i].close();
        }
    }
}


interface IClose {
    public void close();
}
class A implements IClose{
    public void close(){
        System.out.println("A closed");
    }
}


class B implements IClose{
    public void close(){
        System.out.println("B closed");
    }
}


class C implements IClose{
    public void close(){
        System.out.println("C closed");
    }
}