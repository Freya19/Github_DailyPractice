package freya19.practice.笔试.hs;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class 数组公共元素 {

    public int[] solve(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        int p1 = 0, p2 = 0;
        ArrayList<Integer> tmp = new ArrayList();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                tmp.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine().trim();
        String s2 = in.nextLine().trim();

        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");

        int[] arr1 = new int[ss1.length];
        for (int i = 0; i < ss1.length; i++) {
            arr1[i] = Integer.parseInt(ss1[i]);
        }

        int[] arr2 = new int[ss2.length];
        for (int i = 0; i < ss2.length; i++) {
            arr2[i] = Integer.parseInt(ss2[i]);
        }

        数组公共元素 m = new 数组公共元素();
        int[] res = m.solve(arr1, arr2);

        for (int i : res) {
            System.out.println(i);
        }

    }
}
