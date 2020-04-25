package gepeng18.笔试.春季编程大赛2020;

public class 数组切分的最大最小值 {
    public static int split(int[] arr, int start, int end, int k) {
        if (k == 1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            return sum;
        }
        if ((end - start + 1) == k) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (arr[i] > max) {
                    max = arr[i];

                }
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            int sum = 0;
            for (int j = start; j <= i; j++) {
                sum += arr[j];
            }
            int larger = sum > split(arr, i + 1, end, k - 1) ? sum : split(arr, i + 1, end, k - 1);
            if (larger < min) {
                min = larger;

            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.print(new 数组切分的最大最小值().split(arr, 0,arr.length-1,2));
    }
}
