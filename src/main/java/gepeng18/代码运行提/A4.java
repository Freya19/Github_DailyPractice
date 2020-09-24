package gepeng18.代码运行提;

public class A4 {
    public static  void operator(StringBuffer x,StringBuffer y){
        x.append(y);
        y = x;
    }
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a,b);
        System.out.println(a+","+b);

    }
}
