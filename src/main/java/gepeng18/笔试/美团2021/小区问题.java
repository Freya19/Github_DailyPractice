package gepeng18.笔试.美团2021;

import java.util.*;
import java.util.ArrayList;

// "1,2","2,3","1,5","11,12"： 首先使用一个数表示小区的数量，初始化为0
// 当出现1,2时，表明1,2在同一个小区（题目要求），而这两个在hashmap中没有出现过，
//               则表明是新的小区，将0赋值给他们两，小区数量+1 变为1，并且记录到hashmap中 1:0 2:0
// 当出现2,3时，表明2,3在同一个小区（题目要求），而2出现过，是0号小区，则3也是0号小区，hashmap记录3:0
// 当出现1,5时，表明1,5在同一个小区（题目要求），而1出现过，是0号小区，则5也是0号小区，hashmap记录5:0
// 当出现11,12时，表明11,12在同一个小区（题目要求），而这两个在hashmap中没有出现过，
//               则表明是新的小区，将1赋值给他们两，小区数量+1 变为2，并且记录到hashmap中 11:1 12:1
// 同时，还需要记录每个小区序号的数字，那就在遍历的时候，组件arraylist数组，往里加。只是注意一下，当出现 2,2时，
// 不能全部往里加，只加一个即可，否则会重复
public class 小区问题 {
    public void solve(String [] pairs){
        int cycle = 0;
        HashMap<String, Integer> flag = new HashMap<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (String pair:pairs){
            String[] split = pair.split(",");

            //  a b 都没有出现过
            if(!flag.containsKey(split[0])&&!flag.containsKey(split[1])){
                flag.put(split[0],cycle);
                flag.put(split[1],cycle);
                cycle++;
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(Integer.valueOf(split[0]));
                // 只有当出现 a a且 a 没出现过，会导致重复
                if(!split[0].equals(split[1]))
                    cur.add(Integer.valueOf(split[1]));
                res.add(cur);
            }else if(flag.containsKey(split[0])&&!flag.containsKey(split[1])){
                // a出现过 b没出现过 则将a的值赋给b
                flag.put(split[1],flag.get(split[0]));
                ArrayList<Integer> cur = res.get(flag.get(split[0]));
                cur.add(Integer.valueOf(split[1]));
            }else if(flag.containsKey(split[0])&&!flag.containsKey(split[1])){
                // b出现过 a没出现过 则将b的值赋给a
                flag.put(split[0],flag.get(split[1]));
                ArrayList<Integer> cur = res.get(flag.get(split[1]));
                cur.add(Integer.valueOf(split[0]));
            }else {
                throw  new RuntimeException("不可能");
            }
        }
        for (ArrayList list:res){
            Collections.sort(list);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        new 小区问题().solve(new String[]{"1,2","2,2","2,3","1,5",
                                         "11,12","12,18","16,11",
                                         "19,15",
                                         "21,20"});
    }
}
