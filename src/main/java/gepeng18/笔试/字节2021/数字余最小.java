package gepeng18.笔试.字节2021;

import java.util.TreeSet;

/**
 * 第四题给出n和m，n个数字a[i]，每个数字只能用一次，问能凑出的最大的sum%m，sum是数字取和，其中n最大为35，m最大1e9+7。
 */
public class 数字余最小 {
    int [] num;
    int m;
    int max = -1;
    TreeSet<Integer> set1 = new TreeSet<>();
    TreeSet<Integer> set2 = new TreeSet<>();

    public int solve(int [] num){
        this.num = num;
        int mid  = num.length/2;
        dfs1(0,0);
        dfs2(mid,0);

        Integer[] array1 = set1.toArray(new Integer[set1.size()]);
        Integer[] array2 = set1.toArray(new Integer[set2.size()]);
        int index1 = 0;
        int index2 = array2.length-1;
        while (index1<array1.length&&index2>=0){
            max = Math.max(max,(array1[index1]+array2[index2])%m);
            if ((array1[index1]+array2[index2])%m == m-1)
                return m-1;
            else if((array1[index1]+array2[index2])%m > m-1)
                index1++;
            else
                index2--;
        }
        return max;
    }

    // 目前考虑第Index个数，之前的所有数之和为sum
    void dfs1(int index,int sum){
        if(index == num.length/2){
            set1.add(sum);
        }
        // 考虑第index+1去，和已经变了，即加上这个数
        dfs1(index+1,(sum+num[index+1])%m);
        dfs1(index+1,sum%m);

    }

    // 目前考虑第Index个数，之前的所有数之和为sum
    void dfs2(int index,int sum){
        if(index == num.length){
            set1.add(sum);
        }
        dfs2(index+1,(sum+num[index+1])%m);
        dfs2(index+1,sum%m);

    }
}
