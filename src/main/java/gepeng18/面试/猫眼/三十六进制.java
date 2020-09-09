package gepeng18.面试.猫眼;

import java.util.HashMap;
import java.util.Map;


public class 三十六进制 {
    public static void main(String[] args) {

        // 36   0 -9  a-z
        //a1 + z5
        HashMap<Character, Integer> transfer = new HashMap<Character, Integer>();

        for (int i = 0; i < 10; i++)
            transfer.put((char) (i + '0'), i);
        for (int i = 0; i < 26; i++)
            transfer.put((char) (i + 'a'), i + 10);

        String s1 = "a1";
        String s2 = "z5";
        int index1 = s1.length() - 1;
        int index2 = s2.length() - 1;
        int skip = 0;
        StringBuilder res = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int sum = transfer.get(s1.charAt(index1)) + transfer.get(s2.charAt(index2)) + skip;
            if (sum >= 36) {
                skip = 1;
            } else {
                skip = 0;
            }
            for (Map.Entry<Character, Integer> entry : transfer.entrySet()) {
                if (entry.getValue() == sum % 36) {
                    res.append(entry.getKey());
                    break;
                }
            }
            index1--;
            index2--;
        }
        if (index1 == 0) {
            while (index2 >= 0) {
                int sum = transfer.get(s2.charAt(index2)) + skip;
                if (sum >= 36) {
                    skip = 1;
                } else {
                    skip = 0;
                }
                for (Map.Entry<Character, Integer> entry : transfer.entrySet()) {
                    if (entry.getValue() == sum % 36) {
                        res.append(entry.getKey());
                        break;
                    }
                }
                index2--;
            }
        } else {
            while (index1 >= 0) {
                int sum = transfer.get(s1.charAt(index1)) + skip;
                if (sum >= 36) {
                    skip = 1;
                } else {
                    skip = 0;
                }

                for (Map.Entry<Character, Integer> entry : transfer.entrySet()) {
                    if (entry.getValue() == sum % 36) {
                        res.append(entry.getKey());
                        break;
                    }
                }
                index1--;
            }
        }
        if (skip == 1)
            res.append(1);
        String resString = res.reverse().toString();
    }
}

