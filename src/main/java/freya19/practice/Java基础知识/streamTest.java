package freya19.practice.Java基础知识;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.TreeSet;

// ID为偶数，年龄>24，用户名转成大写，按用户名字母倒序，只输出一个用户名

@AllArgsConstructor  // 自动创建构造器
@Data   //get set toString
@NoArgsConstructor // 无参构造器
@Accessors(chain = true) // 允许链式编程
class User implements  Comparable<User>{
    private int id;
    private String userName;
    private int age;

    @Override
    public int compareTo(User anotherUser) {
        return age - anotherUser.getAge();
    }

}



public class streamTest {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);
        User u6 = new User(18,"f",25);

        TreeSet<User> set = new TreeSet<>();
        set.add(u1);
        set.add(u2);
        set.add(u3);
        set.add(u4);
        set.add(u5);
        set.add(u6);

        System.out.println(set);

//        List<User> list = Arrays.asList(u1,u2,u3,u4,u5,u6);
//
//        list.sort((uu1, uu2) -> {
//           return uu1.getAge()-uu2.getAge();
//        });
//        System.out.println(list);

//
//        // 流式计算+链式编程
//        list.stream().filter(u->{ //id为偶数
//            return u.getId()%2==0;
//        }).filter(u->{ // 年龄大于24
//            return u.getAge()>24;
//        }).map(u->{ //用户名转大写
//            return 1;
//        }).sorted((o1,o2)->{ // 排序

//        }).forEach(System.out::println);

        // dir3/file1.txt
//        String s3 = "dir3";
//        String s4 = "dir4";
//        String s5 = "file1.txt";
//        String s1 = "dir1";
//        String s2 = "dir2";
//        String s6 = "file2.txt";
//        List list = new ArrayList();
//        list.add(s1);
//        list.add(s2);
//        list.add(s3);
//        list.add(s4);
//        list.add(s5);
//        list.add(s6);

//        List newList = (List) list.stream().sorted((ss1, ss2) -> {
//           return ((String)ss1).indexOf(".")-((String)ss2).indexOf(".");
//        }).collect(Collectors.toList());
//        System.out.println(newList);

//        List dirs = (List) list.stream().filter(ss -> {
//            return ((String) ss).indexOf(".") < 0;
//        }).collect(Collectors.toList());
//
//        List files = (List) list.stream().filter(ss -> {
//            return ((String) ss).indexOf(".") > 0;
//        }).collect(Collectors.toList());
//
//
//        List<String>  newLit = new ArrayList<>();
//        newLit.addAll(dirs);
//        newLit.addAll(files);
//        System.out.println(newLit);
    }


}
