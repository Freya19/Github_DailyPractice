package gepeng18.考试.猫眼;

import javax.activation.MailcapCommandMap;
import java.util.HashMap;
import java.util.Map;

/**
 * 模仿字符串相加的代码写法
 */
public class 三十六进制2 {
    public static String add(String a,String b){
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> transfer = new HashMap<>();
        for (int i = 0;i<9;i++){
            transfer.put((char) (i+'0'),i);
        }
        for (int i = 0;i<26;i++){
            transfer.put((char) (i+'a'),i+10);
        }
        int add = 0;
        int indexA = a.length()-1;
        int indexB = b.length()-1;

        while (indexA>=0 || indexB>=0 || add>0){
            int x = indexA>=0?transfer.get(a.charAt(indexA)):0;
            int y = indexB>=0?transfer.get(b.charAt(indexB)):0;
            int sum = x + y + add;
            if (sum>35){
                add = 1;
            }else
                add = 0;
            for (Map.Entry<Character, Integer> entry : transfer.entrySet()) {
                if (entry.getValue() == sum % 36) {
                    res.append(entry.getKey());
                    break;
                }
            }
            indexA--;
            indexB--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = add("b1", "12");
        System.out.println(res);
    }

}
