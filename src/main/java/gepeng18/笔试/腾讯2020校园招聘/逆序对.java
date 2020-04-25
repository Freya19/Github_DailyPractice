package gepeng18.笔试.腾讯2020校园招聘;

import java.util.*;

/**
 *  作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
 * 老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
 *
 * 例如:
 * 对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
 * 翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
 *
 * 输入描述:
 *
 * 第一行一个数
 * 第二行个数，表示初始的序列()
 * 第三行一个数
 * 第四行m个数表示
 *
 *
 * 输出描述:
 *
 * m行每行一个数表示答案。
 *
 *
 * 输入例子1:
 *
 * 2
 * 2 1 4 3
 * 4
 * 1 2 0 2
 *
 *
 * 输出例子1:
 *
 * 0
 * 6
 * 6
 * 0
 *
 *
 * 例子说明1:
 *
 * 初始序列2 1 4 3
 * 2^{q_1} = 2 ->
 * 第一次：1 2 3 4 -> 逆序对数为0
 * 2^{q_2} = 4 ->
 * 第二次：4 3 2 1 -> 逆序对数为6
 * 2^{q_3} = 1 ->
 * 第三次：4 3 2 1 -> 逆序对数为6
 * 2^{q_4} = 4 ->
 * 第四次：1 2 3 4 -> 逆序对数为0
 */

/**
 * 您的代码已保存
 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
 * case通过率为40.00%
 * 用时：40分钟
 */
public class 逆序对 {
    Stack<Integer> stack = new Stack();
    List<Integer> nums = new ArrayList<>();
    List<Integer> request = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    //找逆序对
    public int computeNixu(List<Integer> nums) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                if (nums.get(i) > nums.get(j))
                    count++;
            }
        }
        return count;
    }

    public void solution() {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < request.size(); i++) {

            for (int j = 0; j < nums.size(); j++) {

                //当栈中数量小于2的 次方时，继续插入,否则弹出到tmp中
                if (stack.size() < Math.pow(2, request.get(i)))
                    stack.add(nums.get(j));

                if (stack.size() == (int) Math.pow(2, request.get(i))) {
                    while (stack.size() != 0)
                        tmp.add(stack.pop());
                }
            }
            //引用赋值一样要这样
            nums = new ArrayList<>(tmp);
            tmp.clear();
            int pairCount = computeNixu(nums);
            result.add(pairCount);
        }
    }

    private void input() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < (int) Math.pow(2, count); i++) {
            nums.add(in.nextInt());
        }
        count = in.nextInt();
        for (int i = 0; i < count; i++) {
            request.add(in.nextInt());
        }
    }

    private void output() {
        if (result.size() == 0)
            return;
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.println(result.get(i));
        }
        System.out.print(result.get(result.size() - 1));
    }

    public static void main(String[] args) {
//        List<Integer> nums = new ArrayList<>(Arrays.asList(2 ,1 ,4 ,3));
//        List<Integer> request = new ArrayList<>(Arrays.asList(1, 2 ,0 ,2));
//        final 逆序对 instance = new 逆序对();
//        instance.nums = nums;
//        instance.request = request;

        逆序对 instance = new 逆序对();
        instance.input();
        instance.solution();
        instance.output();
    }


}
