package freya19.practice.笔试;

/**
 * 如果一个数的4倍正好是它的逆序数，即为逆序对
 * 不超过n的数中，有多少对逆序对
 */
public class 新定义的逆序对 {

    public static boolean find(int num){

            String s1 = String.valueOf(num);
            String s2 = String.valueOf(4*num);

            if(s1.length() != s2.length()){
                return false;
            }else {
                int p1 =0,p2 = s2.length()-1;
                while (p1 < s1.length() && p2 >= 0){
                    if(s1.charAt(p1) != s2.charAt(p2)){
                        return false;
                    }else {
                        p1++;
                        p2--;
                    }
                }
            }
            return true;
        }

    public static void main(String[] args) {
        int n = (int) Math.pow(10,7);
//        for(int i=1;i<n;i++){
//            if(find(n)){
//                System.out.println(i+" "+4*i);
//            }
//        }

        System.out.println(n);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
