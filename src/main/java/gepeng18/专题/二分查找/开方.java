package gepeng18.专题.二分查找;

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

    public static void main(String[] args) {
        int sqrt = sqrt(2147395599);
        System.out.println(sqrt);
    }


}
