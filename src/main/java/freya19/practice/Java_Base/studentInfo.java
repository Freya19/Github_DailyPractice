package freya19.practice.Java_Base;

import java.util.HashMap;
import java.util.Map;

/*
定义一个map容器来存储学生信息（id，name，score）
最终可以通过容器查找到学生的信息
 */
public class studentInfo {
    // 学生类
        String name;
        int score;

        public studentInfo(String name, Integer score){
            this.name= name;
            this.score=score;
    }

    public static void main(String[] args) {
        studentInfo s1 = new studentInfo("gp",100);
        studentInfo s2 = new studentInfo("fhy",100);

        //定义一个容器，用来放学生的信息
        //容易被自己忽略的是： map是interface，不能用来实现，而它的实现一般有HashMap，所以出现下面一行代码
        Map<Integer,studentInfo> mp = new HashMap<Integer, studentInfo>();

        mp.put(1,s1);
        mp.put(2,s2);

        System.out.println(mp.get(1).name);
        System.out.println(mp.get(2).name);
    }
}
