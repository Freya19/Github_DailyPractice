package freya19.practice.笔试;

public class 三个数组匹配 {

    public boolean solve(int[] a, int[] b, int[] c) {
        // 索引aindex指向数组a，索引bindex指向数组b，索引cindex指向数组c（初始化都是0）
        int aIndex = 0, bIndex = 0, cIndex = 0;
        // 遍历数组c（移动cindex）判断aindex或bindex处的值与cindex的值是否相等
        while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {
            if (c[cIndex] != a[aIndex] && c[cIndex] != b[bIndex]) {
                // 不等的话直接返回false；
                return false;
            } else if (c[cIndex] == a[aIndex]) {
                // 如果a[aindex]==c[cindex]  aindex++，cindex++；
                cIndex++;
                aIndex++;
            } else if (c[cIndex] == b[bIndex]) {
                //同理如果b[bindex]==c[cindex],bindex++,cindex.
                cIndex++;
                bIndex++;
            } else {
                assert (c[cIndex] == a[aIndex] && c[cIndex] == b[bIndex]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        int[] c = new int[]{1, 2, 3, 0, 5, 6};

        boolean res = new 三个数组匹配().solve(a, b, c);
        System.out.println(res);
    }
}
