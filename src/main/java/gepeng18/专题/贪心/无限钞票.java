package gepeng18.专题.贪心;

public class 无限钞票 {
    public static void main(String[] args) {
        int RMB[] = {100, 50, 20, 10, 5, 2, 1};
	    int NUM = 7;
        int X = 628;
        int count = 0;
        for (int i = 0; i < NUM; i++){
            int use = X / RMB[i];
            count += use;
            X = X - RMB[i] * use;
            System.out.println(String.format("需要面额为%d的%d张, ",RMB[i], use));
            System.out.println(String.format("剩余需要支付RMB %d.\n", X));
        }
        System.out.println(String.format("总共需要%d张RMB\n", count));
    }
}
