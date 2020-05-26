package freya19.practice.剑指offer;

public class p305股票最大利润 {
    public int maxProfit(int[] num, int length){
        if(num==null&&num.length<2){
            return 0;
        }

        int minElement = num[0];
        int maxDiff=num[1]-minElement;

        for(int i=2;i<length;i++){
            //元素中最小值
            if(num[i-1]<minElement){
                minElement=num[i-1];
            }

            //差值最大值
            int currentDiff = num[i]-minElement;
            maxDiff = Math.max(currentDiff,maxDiff);

        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] num = {9,11,8,5,7,12,16,14};
        int len = num.length;

        p305股票最大利润 p305 = new p305股票最大利润();
        System.out.println(p305.maxProfit(num,len));
    }
}
