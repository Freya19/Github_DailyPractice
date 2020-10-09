package gepeng18.专题.二分查找.林沐.二分查找;

public class 开方 {
    public static int sqrt(int n){
        long l = 0,r = n;
        while (l<=r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == n)
                return (int)mid;
            else if (mid * mid > n) {
                if ( (mid - 1) * (mid - 1) <= n)
                    return (int)mid - 1;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        throw new RuntimeException("不可能出现这种情况");
    }

//    public static int sqrt(int n){
//        long l = 0,h = n;
//        while (l<=h){
//            long mid = l+(h-l)/2;
//            if (mid*mid==n){
//                return (int) mid;
//            }else if (mid*mid>n){
//                if (mid == 1)
//                    return 0;
//                if((mid-1)*(mid-1)<n)
//                    return (int) mid-1;
//                h = mid-1;
//            }else{
//                l = mid+1;
//            }
//        }
//        throw  new RuntimeException("我觉得不可能");
//    }

    public static int findMin(int state,int w,int [][]r,int a,int b){
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<w;i++){
            if ((r[i][0] == a)&&(r[i][1] == b)){
                min = Math.min(min,state+r[i][2]);
            }else if (r[i][0] == a){
                int cur = findMin(state + r[i][2], w, r, r[i][1], b);
                min = Math.min(min,cur);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int min = findMin(0, 3, new int[][]{
                {0, 1, 600},
                {1, 2, 800},
                {0, 2, 1300}
        }, 0, 2);
        System.out.println(min);
    }

}
