package gepeng18.专题.回溯;

public class 球队踢球 {
    static int getMin(int a,int b){

        if (a<0 || b<0)
            return Integer.MAX_VALUE;

        if (a == 0 && b == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        min = Math.min(min,getMin(a-3,b)+1);
        min = Math.min(min,getMin(a,b-3)+1);
        min = Math.min(min,getMin(a-1,b-1)+1);
        if (min == Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }

    public static void main(String[] args) {
        int res = getMin(0,1);
        System.out.println(res);
    }

}
