package gepeng18.专题.链表;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class 链表迭代器 {
    public static void removeFromLeft(LinkedList list){
        Iterator left = list.iterator();
        int i  = 0;
        while (left.hasNext()){
            left.next();
            if(i%2 == 0){
                left.remove();
            }
            i++;
        }
    }

    public static void removeFromRight(LinkedList list){
        ListIterator right = list.listIterator(list.size());
        int i  = 0;
        while (right.hasPrevious()){
            right.previous();
            if(i%2 == 0){
                right.remove();
            }
            i++;
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1;i<=n;i++)
            list.addLast(i);
        while (list.size()!=1){
            removeFromLeft(list);
            if(list.size()!=1)
                removeFromRight(list);
        }
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
    }
}
