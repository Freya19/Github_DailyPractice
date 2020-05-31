package gepeng18.专题.排序相关的题;

import gepeng18.笔试.模拟考试.注解.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class L451根据字符出现频率排序 {

    public void frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> res = new HashMap<>();
        map.entrySet()
                .stream()
                .sorted((p1, p2) -> {return p2.getValue()- p1.getValue();})
                .collect(Collectors.toList()).forEach(ele -> res.put(ele.getKey(), ele.getValue()));

        System.out.println(res);
    }

    public static void main(String[] args) {
        new L451根据字符出现频率排序().frequencySort("iiijjjskflgjsssjhh");
    }
}
