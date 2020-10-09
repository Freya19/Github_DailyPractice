package gepeng18.专题.二分查找.林沐.二分查找;

public class 范围查询 {
    int left_bound(int [] nums, int target){
        int begin = 0;
        int end = nums.length - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            if (target == nums[mid]){
                if (mid == 0 || nums[mid -1] < target){
                    return mid;
                }
                end = mid - 1;
            } else if (target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                begin = mid + 1;
            }
        }
        return -1;
    }

    int right_bound(int [] nums, int target){
        int begin = 0;
        int end = nums.length - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            if (target == nums[mid]){
                if (mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                }
                begin = mid + 1;
            } else if (target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                begin = mid + 1;
            }
        }
        return -1;
    }

    int [] searchRange(int [] nums, int target) {
        int [] result = new int[]{left_bound(nums, target),right_bound(nums, target)};
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 8, 8, 10};
        范围查询 instance = new 范围查询();

        for (int i = 0; i < 12; i++){
            int [] result = instance.searchRange(nums, i);
            System.out.println(String.format("%d : [%d, %d]\n", i, result[0], result[1]));
        }
    }
}
