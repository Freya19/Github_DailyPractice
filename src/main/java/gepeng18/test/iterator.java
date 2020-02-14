package gepeng18.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class iterator {

    public static void main(String[] args) {




//        List list = new ArrayList<>(Arrays.asList(1,2,3,3,5,6,7));
//
//        Iterator iterator = list.iterator();
//
//        while(iterator.hasNext()){
//            if(iterator.next().equals(3))
//                iterator.remove();
//        }
//        System.out.println(list);


        List<String> list = new ArrayList<>(Arrays.asList("qq","ww","ww","ow"));
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("ww"))
                iterator.remove();
        }
        System.out.println(list);

    }
}
