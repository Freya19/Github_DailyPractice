package freya19.practice.LeetCode;

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。

示例:
输入: [2,0,2,1,1,0]   输出: [0,0,1,1,2,2]

 */
public class L75颜色分类排序 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int L = 0; //一直位于左侧的记录每次情况起始点的索引
        int R = len - 1; //一直往左移动，判断条件的索引

        //找0并排到前面
        while (L < R) {
            if (nums[L] == 0)
                L++;
            else {
                if (nums[R] == 0) {
                    //将找到的0交换到前面的位置
                    int temp = nums[L];
                    nums[L] = nums[R];
                    nums[R] = temp;
                    L++;
                    R--;
                } else {//R位置对应的值为1或2
                    R--;
                }
            }
        }
        //L=R退出上面的while循环，接下来开始找到1 并排到0 之后
        R = len - 1;
        while (L < R) {
            if (nums[R] == 2)
                R--;
            else {
                if (nums[L] == 2) {
                    //将找到的2交换到后面的位置
                    int temp = nums[R];
                    nums[R] = nums[L];
                    nums[L] = temp;
                    L++;
                    R--;
                } else {
                    L++;
                }
            }
        }
    }

    public static void main(String[] args) {
        L75颜色分类排序 l75 = new L75颜色分类排序();
        int[] nums = {1, 0, 0};
//        int[] nums={2,0,2,1,1,0};
        l75.sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

//        int[] res = new int[len];
//        List<Integer> white = new ArrayList<>();
//        List<Integer> blue = new ArrayList<>();
//
//        for(int i=0;i<len;i++){
//            if(nums[i]==2)
//                blue.add(nums[i]);
//            else if(nums[i]==1)
//                white.add(nums[i]);
//            else
//                res[i]=nums[i];
//        }
//
//        int whiteLen = white.size();
//        int blueLen = blue.size();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.
