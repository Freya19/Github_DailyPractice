package freya19.practice.题目分组.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输入: "cccaaa"      输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案.注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 输入: "Aabb"   输出: "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */

public class L451根据字符出现频率排序 {
    public String frequencySort(String s) {

        //将s中每个字符出现的频率记录到hashMap中  ---------------------频率就是频率（value）
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        //再将map中每个字符取出来按照频次由低到高放入list中[{}，{}，{}]，每个小{}代表一种频率 --------- 频率是list的索引
        List<Character>[] charFreqBucket = new ArrayList[s.length() + 1];
        for (char key : charFreq.keySet()) {
            int f = charFreq.get(key);
            if (charFreqBucket[f] == null) {
                charFreqBucket[f] = new ArrayList<Character>();
            }
            charFreqBucket[f].add(key);
        }

        //再把bucket中的元素转换成字符串，并且频次由高到低排    -------------------  频率仍是索引，还是每个bucket的大小
        StringBuilder sb = new StringBuilder();
        for (int i = charFreqBucket.length - 1; i >= 0; i--) {
            if (charFreqBucket[i] == null) {
                continue;
            }

            //对每种频率里的字符操作
            for (char c : charFreqBucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
}
