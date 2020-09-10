package gepeng18.专题.数学;


import java.util.Arrays;

public class 素数 {

    public static int findKth(int[] a, int n, int K) {
        return quickSort(a,0,n-1,K);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    private static int quickSort(int[] arr, int low, int high,int K){
        int p = partion(arr,low,high);
        if(K == p-low+1){
            return arr[p];
        }else if(p-low+1 > K){
            //递归左边
            return quickSort(arr,low,p-1,K);
        }else{
            //递归右边
            return quickSort(arr,p+1,high,K-(p-low+1));
        }
    }
    private static int partion(int[] arr, int low, int high){
        int base = arr[low];
        int first = low;
        while (low < high) {
            while (low < high && arr[high] >= base)
                high--;
            while (low < high && arr[low] <= base)
                low++;
            if (low < high)
                swap(arr, low, high);
        }
        swap(arr, low, first);
        System.out.println(Arrays.toString(arr));
        return low;
    }

    public static void main(String[] args) {
        int kth = findKth(new int[]{1, 3, 5, 2, 2}, 5, 3);
        System.out.println(kth);
    }
}
