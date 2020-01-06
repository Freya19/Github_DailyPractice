package gepeng18.practice.idea;

import java.util.*;

public class NonRepeatThreeTuple {
    public static void main(String[] args) {

        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<List<Integer>> result = solution(data);
        for (List list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> solution(int[] array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Random random = new Random();
        random.setSeed(0);

        for (int i = 0; i < 1000; i++) {
            //threeTuple用来存储三元组，numbers用来判断是否随机生成的数是否存在
            List threeTuple = new ArrayList();
            Set numbers = new HashSet();
            while (threeTuple.size() != 3) {
                //随机生成一个0-array.length的数
                int r = random.nextInt(array.length);
                //生成的数已经在numbers中了，就不管它了，进入下次循环，继续生成
                if (!numbers.contains(array[r])) {
                    numbers.add(array[r]);
                    threeTuple.add(array[r]);
                }
            }
            result.add(threeTuple);
        }
        return result;
    }
}
