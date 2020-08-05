package gepeng18.专题.二分查找.林沐.二分查找;

public class 搜索插入位置1 {
    int searchInsert(int [] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        // 一定有地方能插入，所以index一定有值，没值表明还没找到
        while (index==-1){
            int mid = (begin + end) / 2;
            if (target == nums[mid]){
                index = mid;
            }
            else if (target < nums[mid]){
                if (mid == 0 || target > nums[mid - 1]){
                    index = mid;
                }
                end = mid - 1;
            }
            else if (target > nums[mid]){
                if (mid == nums.length - 1 || target < nums[mid + 1]){
                    index = mid + 1;
                }
                begin = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        搜索插入位置1 solve = new 搜索插入位置1();
        for (int i = 0; i < 8; i++){
            System.out.println(String.format("i = %d index = %d", i, solve.searchInsert(nums, i)));
        }
    }
}
