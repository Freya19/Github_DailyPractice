package freya19.practice.Java基础知识;

public class lowerAndUpperCase {
    public static void main(String[] args) {
//        String s1 = "jAVA";
        String s1 = "jAVA基础";
//        String s2 = "多线程";

//        String s11 = s1.substring(0, 1).1
//        String s = s11 + s12;
        String s = s1.substring(0, 1).toUpperCase()+s1.substring(1).toLowerCase();

//        s2.substring(0,1).toUpperCase();
//        s2.substring(1).toLowerCase();
        System.out.println(s);
//        System.out.println(s12);

    }
}
