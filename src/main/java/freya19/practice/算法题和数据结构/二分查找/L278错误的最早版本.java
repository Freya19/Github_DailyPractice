package freya19.practice.算法题和数据结构.二分查找;

import sun.reflect.generics.tree.Tree;

import java.security.cert.TrustAnchor;

public class L278错误的最早版本 {
    public int isWrongVersion(int[] versions) {

        int l = 0, r = versions.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (versions[mid] == 1) {
                if (mid == 0 || versions[mid - 1] == 0) {
                    return mid;
                }
                r = mid - 1;
            } else if (versions[mid] == 0) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ver = new L278错误的最早版本().isWrongVersion(new int[]{0, 0, 0, 0, 0, 1});
        System.out.println(ver);
    }
}
