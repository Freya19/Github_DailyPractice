package freya19.practice.题目分组.字符串;

/**
 * s = "We are happy."
 * "We%20are%20happy."
 *
 * 4′59″
 *
 * 剑指offer用的是双指针+复制
 */
public class SO5替换空格Easy {
    public String replaceSpace(String s) {
        if(s==null||s.length()==0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }
}
