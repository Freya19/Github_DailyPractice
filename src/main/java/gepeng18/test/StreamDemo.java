//package gepeng18.test;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class User
//{
//    private Integer id;
//    private String  userName;
//    private int     age;
//}
//
//public class StreamDemo {
//    public static void main(String[] args) {
//        User u1 = new User(11,"a",23);
//        User u2 = new User(12,"b",24);
//        User u3 = new User(13,"c",22);
//        User u4 = new User(14,"d",28);
//        User u5 = new User(16,"e",26);
//
//        List<User> list = Arrays.asList(u3,u4,u1,u2,u5);
//
//        //不会进行排序，因为它返回一个新的stream对象
//        list.stream().sorted((user1,user2)->{return user1.getId()-user2.getId();});
//
//        /* ------------------- 演示延迟执行 ----------------- */
//        //不会进行排序，因为它是延迟执行的，只有需要结果的时候才执行
//        final Stream<User> userStream = list.stream().filter(
//                u -> {
//                    System.out.println("我执行过滤啦");
//                    return true;
//                });
//        System.out.println("现在开始需要结果----------");
//
//        /**
//         * 现在开始需要结果----------
//         * 我执行过滤啦
//         * 13
//         * 我执行过滤啦
//         * 14
//         * 我执行过滤啦
//         * 11
//         * 我执行过滤啦
//         * 12
//         * 我执行过滤啦
//         * 16
//         */
//        userStream.forEach(u->{
//            System.out.println(u.getId());
//        });
//
//
//        /**
//         * 现在开始需要结果----------
//         * 我执行过滤啦
//         * 我执行过滤啦
//         * 我执行过滤啦
//         * 我执行过滤啦
//         * 我执行过滤啦
//         * [User(id=13, userName=c, age=22), User(id=14, userName=d, age=28), User(id=11, userName=a, age=23), User(id=12, userName=b, age=24), User(id=16, userName=e, age=26)]
//         */
////        final List<User> collect = userStream.collect(Collectors.toList());
////        System.out.println(collect);
//
//
//    }
//}
