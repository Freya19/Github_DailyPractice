package freya19.practice.算法题和数据结构.数组和矩阵;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
 */
public class SO11旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (numbers[l] == numbers[mid] && numbers[mid] == numbers[r]) {
                return minArray(numbers, l, r);
            } else if (numbers[mid] <= numbers[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return numbers[l];
    }

    /**
     * l,mid,r三处元素相等，直接顺序查找
     */
    public int minArray(int[] array, int l, int h) {
        for (int i = l; i < h; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        //原数组递增
        return array[l];
    }

//    public static void main(String[] args) {
//        int res = new T11旋转数组的最小数字().minNumber(new int[]{3, 1, 3});
//        System.out.println(res);
//    }
}