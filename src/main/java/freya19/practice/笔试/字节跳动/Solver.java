package freya19.practice.笔试.字节跳动;


import java.util.*;

class Solver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 用户个数
        int userNums = in.nextInt();
        // 用户对某文章的喜爱度
        int[] userLikes = new int[userNums];
        for (int i = 0; i < userNums; i++) {
            userLikes[i] = in.nextInt();
        }
        // 待查询 组 数 —— q组
        int q = in.nextInt();
        int[] res = new int[q];
        // 对于每一组查询 进行判断是否有满足条件的
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            // 每一组查询的目标喜爱度
            int m = in.nextInt();
            // 对[l-r]范围进行查找判断是否有等于m的喜爱度的用户
            int userLike = 0;
            for (int j = l - 1; j < r; j++) {
                if (userLikes[j] == m) {
                    userLike++;
                }
            }
            System.out.println(userLike);
        }


    }
}
