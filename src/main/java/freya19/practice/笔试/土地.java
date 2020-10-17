package freya19.practice.笔试;

import java.util.HashSet;
import java.util.Scanner;

public class 土地 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int all = input.nextInt();
        int a_length = input.nextInt();
        int b_length = input.nextInt();

        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        for (int i = 0;i<a_length;i++)
            a.add(input.nextInt());

        for (int i = 0;i<b_length;i++)
            b.add(input.nextInt());

        HashSet<Integer> res = new HashSet<>(a);
        res.removeAll(b);
        System.out.println(res.size());
        res = new HashSet<>(b);
        res.removeAll(a);
        System.out.println(res.size());
        res = new HashSet<>(b);
        res.retainAll(a);
        System.out.println(res.size());
    }
}