package freya19.practice.Java_Base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ID为偶数，年龄>24，用户名转成大写，按用户名字母倒序，只输出一个用户名

@AllArgsConstructor  // 自动创建构造器
@Data   //get set toString
@NoArgsConstructor // 无参构造器
@Accessors(chain = true) // 允许链式编程
class User{
    private int id;
    private String userName;
    private int age;
}

public class streamTest {
    public static void main(String[] args) {
//        User u1 = new User(11,"a",23);
//        User u2 = new User(12,"b",24);
//        User u3 = new User(13,"c",22);
//        User u4 = new User(14,"d",28);
//        User u5 = new User(16,"e",26);
//        User u6 = new User(18,"f",25);
//
//        List<User> list = Arrays.asList(u1,u2,u3,u4,u5,u6);
//
//        // 流式计算+链式编程
//        list.stream().filter(u->{ //id为偶数
//            return u.getId()%2==0;
//        }).filter(u->{ // 年龄大于24
//            return u.getAge()>24;
//        }).map(u->{ //用户名转大写
//            return u.getUserName().toUpperCase();
//        }).sorted((o1,o2)->{ // 排序
////            return o1.compareTo(o2);  // 原序：D E F
//            return o2.compareTo(o1);    // 倒序：F D E
//        }).forEach(System.out::println);


        // dir3/file1.txt
            String s3 = "dir3";
            String s4 = "dir4";
            String s5 = "file1.txt";
            String s1 = "dir1";
            String s2 = "dir2";
            String s6 = "file2.txt";
            List list = new ArrayList();
            list.add(s3);
            list.add(s3);
            list.add(s3);




    }
}
