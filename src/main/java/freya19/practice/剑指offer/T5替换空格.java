package freya19.practice.剑指offer;

/**
 * s = "We are happy."
 * "We%20are%20happy."
 *
 * 4′59″
 *
 * 剑指offer用的是双指针+复制
 */
public class T5替换空格 {
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
