package freya19.practice.leetcode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class User{
    private int id;
    private String name ;
    private int age ;
}


//select id from users where id between 3 and 5 and age between 10 and 18 order by age （前后都包）
public class SelectJava {

    public static void main(String[] args) {
        User gp = new User(1, "gp", 18);
        User fyy = new User(2, "fyy", 10);
        User xdd = new User(3, "xdd", 12);
        User fhy = new User(4, "fhy", 15);
        User gpp = new User(5, "gpp", 10);

        List<User> users = Arrays.asList(gp, fyy, xdd, fhy, gpp);
        SelectJava s = new SelectJava();
    }

    public static List<Integer> select(List<User> list){
        List<Integer> ret = new ArrayList();
        int temp = 0;
        for(User l:list){
            if((l.getId()>=3 && l.getId()<=5) && (l.getAge()>=10 && l.getAge()<=18)) {
                if(l.getAge() >= temp){
                    ret.add(l.getId());
                    temp = l.getAge();
                } //不会了


            }
        }

        for(Object i:ret){
            System.out.println((Integer) i);
        }
        return ret;
    }
}

