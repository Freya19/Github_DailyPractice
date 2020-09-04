package gepeng18.笔试.中国农行;

public class 质心 {

    public static  int get_index(String [] points){
        int length = points.length;
        long num1 = 0;
        long num2 = 0;

        for (int i = 0; i< length; i++){
            String point = points[i];
            String[] nums = point.split(",");
            Long first = Long.valueOf(nums[0]);
            Long second = Long.valueOf(nums[1]);
            num1+=first;
            num2+=second;
        }
        num1 = num1/length;
        num2 = num2/length;

        int minIndex = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i< length; i++){
            String point = points[i];
            String[] nums = point.split(",");
            Long first = Long.valueOf(nums[0]);
            Long second = Long.valueOf(nums[1]);
            double distance = Math.pow(first - num1, 2) + Math.pow(second - num2, 2);
            if (distance <min){
                min = distance;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int index = get_index(new String[]{"1,1", "2,2", "1,2", "1,3"});
        System.out.println(index);
    }
}
