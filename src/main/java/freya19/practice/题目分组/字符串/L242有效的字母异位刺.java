package freya19.practice.题目分组.字符串;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"     输出: true
 */

public class L242有效的字母异位刺 {
    public boolean isAnagram(String s, String t) {

        int[] counts = new int[26];

        for(char c:s.toCharArray()){
            counts[c-'a']++;
        }

        for(char c:t.toCharArray()){
            counts[c-'a']--;
        }

        for(int count:counts){
            if(count!=0){
                return false;
            }
        }
        return true;
    }


}

/* if (s == null || t == null) {
            return true;
        }

        if(s.length()==0||t.length()==0){
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            int value =sFreq.getOrDefault(key,0);
            sFreq.put(key, value+1);
        }

        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            int value =tFreq.getOrDefault(key,0);
            tFreq.put(key, value+1);
        }

        if(sFreq.size()!=tFreq.size()){
            return false;
        }

        Set<Character> sKeySets = sFreq.keySet();
        Set<Character> tKeySets = tFreq.keySet();
        for(char key:sKeySets){
            if(tKeySets.contains(key)&&sFreq.get(key).equals(tFreq.get(key))){
                return true;
            }
        }
        return false;*/