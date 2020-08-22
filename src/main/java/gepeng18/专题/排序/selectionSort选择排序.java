package gepeng18.专题.排序;

public class selectionSort选择排序 {

    /**
     * 将数组中的数字按从小到大的顺序排列
     * @param nums 待排序的数组
     * @param n 数组的长度
     */
    public void selectionSort(int[] nums, int n){
        for(int i =0;i<n;i++){
            int minIndex=i;
            //i之后的元素中找最小值
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[minIndex])
                    minIndex=j;
            }
            //将找到的最小值与首位交换
            int temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;
        }
    }


    public static void main(String[] args) {
        int[] nums= {2,1,3,6,4,5,8,7};
        int n = nums.length;
        selectionSort选择排序 ss = new selectionSort选择排序();
        ss.selectionSort(nums,n);
        for(int num:nums){
            System.out.print(num);
        }
        System.out.println();
    }

}
