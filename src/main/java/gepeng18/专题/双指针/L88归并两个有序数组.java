package gepeng18.专题.双指针;

import java.util.Arrays;

public class L88归并两个有序数组 {
    public void merge(int[] num, int m, int[] num2, int n) {
        int [] num1 = new int[m];
        for(int i=0;i<m;i++){
            num1[i] = num[i];
        }

        for(int i=0,j=0,k=0; i<m || j<n;){
            if(i == m){
                num[k] = num2[j];
                j++;
            }
            else if(j==n){
                num[k] = num1[i];
                i++;
            }else if(num1[i] < num2[j]){
                num[k] = num1[i];
                i++;
            }else {
                num[k] = num2[j];
                j++;
            }
            k++;
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[6];
        num1[0] = 1;
        num1[1] = 2;
        num1[2] = 3;
        int[] num2 = new int[]{2,5,6};

        new L88归并两个有序数组().merge(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));
    }
}
