package gepeng18.笔试.华为校招;

import java.util.HashMap;
import java.util.Scanner;

/**
 *

 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

 输入描述:
 输入一个十六进制的数值字符串。
 输出描述:
 输出该数值的十进制字符串。

 输入例子1:
 0xA

 输出例子1:
 10

 */
public class 进制转换 {
    public static void main(String[] args) {
        final HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<10;i++)
            map.put((char) (i+'0'),i);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String s = in.nextLine();
            s = s.substring(2);

            int num = 0;
            for(int i=0;i<s.length();i++){
                num = num*16+map.get(s.charAt(i));
            }
            System.out.println(num);
        }


    }
}
