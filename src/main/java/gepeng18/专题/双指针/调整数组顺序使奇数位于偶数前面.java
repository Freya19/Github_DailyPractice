package gepeng18.专题.双指针;

/**
 * 题目描述：
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 问题解析：
 *
 * 这道题有挺多种解法的，给大家介绍一种我觉得挺好理解的方法：
 *
 * 第一种方式
 * 我们首先统计奇数的个数假设为n,然后新建一个等长数组，
 * 然后通过循环判断原数组中的元素为偶数还是奇数。如果是则从数组下标0的元素开始，
 * 把该奇数添加到新数组；如果是偶数则从数组下标为n的元素开始把该偶数添加到新数组中。
 *
 * 第二种方式
 * 建立一个数组只存奇（数组初始化长度为array.length  初始化元素为-1)
 * 建立一个数组只存偶（数组初始化长度为array.length  初始化元素为-1)
 * 遍历array 奇的存奇数组  偶的存偶数组
 * 建立结果时，先取奇数组，不是-1则加到结果中
 * 再取偶数组，不是-1则加到结果中
 *
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int[] array) {
        //如果数组长度等于0或者等于1，什么都不做直接返回
        if (array.length == 0 || array.length == 1)
            return;
        //oddCount：保存奇数个数
        //oddBegin：奇数从数组头部开始添加
        int oddCount = 0, oddBegin = 0;
        //新建一个数组
        int[] newArray = new int[array.length];
        //计算出（数组中的奇数个数）开始添加元素
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) oddCount++;
        }
        for (int i = 0; i < array.length; i++) {
            //如果数为基数新数组从头开始添加元素
            //如果为偶数就从oddCount（数组中的奇数个数）开始添加元素
            if ((array[i] & 1) == 1)
                newArray[oddBegin++] = array[i];
            else newArray[oddCount++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
