package freya19.practice.算法题和数据结构.贪心;

public class T0倍数关系面额钞票支付问题 {
    public static void main(String[] args) {
        // 不同面额的人民币（无穷多张）
        int[] rmb = {100, 50, 20, 10, 5, 2, 1};
        // 共有几种类型的面值（7种）
        int kinds = rmb.length;

        // 待支付的金额
        int payment = 628;
        // 使用了count张人民币
        int count = 0;

        for (int i = 0; i < kinds; i++) {
            int use = payment / rmb[i]; // 628/100=6,所以需要6张100的
            count += use;

            // 还剩多少钱（628-100*6=28）
            payment = payment - rmb[i] * use;

            System.out.print("需要 " + use + " 张" + rmb[i] + "元人民币");
            System.out.println("还剩 " + payment + " 元");
        }
        System.out.println();
        System.out.println("一共用了"+count+"张人民币");
    }
}
