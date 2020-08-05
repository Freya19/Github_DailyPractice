package gepeng18.专题.二分查找.林沐.相关题目;

/**
 * 竟然写出来了，好开心啊
 */
public class L278第一个出错的版本 {
    public int firstBadVersion(int n) {
        int begin = 1, end = n;

        while (begin <= end) {
            int mid = begin+(end-begin)/2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1))
                    return mid;
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        //必须有返回值
        return -1;
    }

    // 只是为了在ide中不报错
    boolean isBadVersion(int i) {
        if (i >= 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        L278第一个出错的版本 solver = new L278第一个出错的版本();
        int i = solver.firstBadVersion(8);
        System.out.println(i);
    }
}
