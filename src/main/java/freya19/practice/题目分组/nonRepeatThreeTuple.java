package freya19.practice.JavaCode;

import java.util.*;

public class nonRepeatThreeTuple {

    public static List<List<Integer>> saveThreeTuple(int [] arr){ // 存不重复三元数组的方法
        List<List<Integer>> ret =new ArrayList<List<Integer>>(); // 最终存放1000个不重复三元数组的大数组
        Random rdm = new Random(); // 创建对象，18行是利用这个对象来调用nextInt()方法的
        rdm.setSeed(0);

        for(int i=0;i<1000;i++){
            //1. 首先先创建一个数组,存不重复元素；再创建一个set，用来判断是否包含（重复）
            List<Integer> threeTuple = new ArrayList<Integer>();
            Set<Integer> nums =new HashSet<Integer>();

            while(threeTuple.size()!=3){ // 当这个三元数组没有存满时，
                int r = rdm.nextInt(arr.length); //先以传入的原数组长度来随机生成一个数（是索引）
                if(!nums.contains(arr[r])){ // 然后判断这个索引对应的arr[r]是否重复了，如果不重复
                    nums.add(arr[r]);  // 就加入到判断数组中
                    threeTuple.add(arr[r]); // 再加入到三元数组中
                }
            }ret.add(threeTuple); // 当存满三个后，将其添加到一开始创建的二维数组中存放
        }return ret; // 并最终返回这个二维数组
    }

    public static void main(String[] args) {
        int [] arr ={1,2,3,5,4,6,7,8,9};
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        result = saveThreeTuple(arr);
        for(List list:result){
            System.out.println(list);
        }
    }
}






