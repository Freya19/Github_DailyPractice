package gepeng18.专题.二分查找.林沐.二分查找;

public class 搜索插入位置 {
    int searchInsert(int [] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        // 一定有地方能插入，所以index一定有值，没值表明还没找到
        while (begin<=end){
            int mid = (begin + end) / 2;
            if (target == nums[mid]){
                index = mid;
                return index;
            } else if (target < nums[mid]){
                if (mid == 0 || target > nums[mid - 1]){
                    index = mid;
                    return index;
                }
                end = mid - 1;
            } else if (target > nums[mid]){
                // 其实这里可以将 target < nums[mid + 1] 去掉
                if (mid == nums.length - 1 || target < nums[mid + 1]){
                    index = mid + 1;
                    return index;
                }
                begin = mid + 1;
            }
        }
         throw  new RuntimeException("因为有地方插入，所以上面的插入条件肯定有一个会满足");
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        搜索插入位置 solve = new 搜索插入位置();
        for (int i = 0; i < 8; i++){
            System.out.println(String.format("i = %d index = %d", i, solve.searchInsert(nums, i)));
        }
    }
}
