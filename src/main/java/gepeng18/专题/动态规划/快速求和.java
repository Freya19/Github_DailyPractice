package gepeng18.专题.动态规划;

public class 快速求和 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] sum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int[] inputs = {1, 2};
        System.out.println(sum[inputs[1] + 1] - sum[inputs[0]]);
    }
}
