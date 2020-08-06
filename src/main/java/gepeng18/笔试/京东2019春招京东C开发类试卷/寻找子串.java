package gepeng18.笔试.京东2019春招京东C开发类试卷;


import java.util.*;

/**
 * https://www.nowcoder.com/question/next?pid=16778489&qid=370629&tid=35563145
 *
 * 给出m个字符串S1，S2，...，Sm和一个单独的字符串T。请在T中选出尽可能多的子串同时满足：  1）这些子串在T中互不相交。  2）这些子串都是S1，S2，...，Sm中的某个串。  问最多能选出多少个子串。
 *
 * 输入描述:
 * 第一行一个数m（1≤m≤10），接下来m行，每行一个串。最后一行输入一个串T。输入中所有单个串的长度不超过100000，串中只会出现小写字母。
 *
 * 输出描述:
 * 输出一个数，最多能选出多少串。
 *
 * 输入例子1:
 * 3
 * aa
 * b
 * ac
 * bbaac
 *
 * 输出例子1:
 * 3
 */

/** 题解：先求所有的区间，使用左边右开的形式，然后转化为贪心算法求不相交区间问题，但是不知道为啥只过了85%
 *  左闭右开是因为 ： liuyubobo的求不相交区间问题是 [1,2] [2,3]算作不相交的，即边界相交不算，
 *  bbaac 搜 a bc 则搜到的区间为[2,2] [3,3] [3,4]这样最后两个不相交,但其实已经相交了，所以转化为 [3,4)  [3,5) 这样就是相交的
 *
 */
public class 寻找子串 {
    static class Interval{
        int start;
        int end;

        public  Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static List<Interval> returnInterval(String string, String substring){
        ArrayList<Interval> res = new ArrayList<>();
        int i = string.indexOf(substring);
        while (i!=-1){
            res.add(new Interval(i,i+substring.length()));
            i = string.indexOf(substring,i+1);
        }
        return res;
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end != o2.end)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int res = 1;
        int pre = 0;
        for(int i = 1 ; i < intervals.length ; i ++)
            if(intervals[i].start >= intervals[pre].end){
                res ++;
                pre = i;
            }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        int num = in.nextInt();
        if(num == 0)
            System.out.println(0);
        in.nextLine();
        while (num-->0){
            inputs.add(in.nextLine().trim());
        }
        String s = in.nextLine().trim();
        List<Interval> intervals = new ArrayList<>();
        for (String substring:inputs)
            intervals.addAll(returnInterval(s,substring));
        int res = eraseOverlapIntervals(intervals.toArray(new Interval[intervals.size()]));
        System.out.println(res);

    }
}
