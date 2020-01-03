package gepeng18.practice.idea;
/*
给定一个字符串，找出不含有重复字符的 最长子串 的长度。
难度：中
示例：
给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串
*
**/
public class MaxUnrepeatedSeqLength {
    public static void main(String[] args) {

        String str = new String("pwwkew");
        boolean[] used = new boolean[128];
        for(int i=0;i<128;i++)
            used[i] = false;
        int left = 0,right = 0,maxLength=0;
        while(right<str.length()){
            if(!used[str.charAt(right)]){
                used[str.charAt(right)] = true;
                right++;

            }else{
                while(left<right && str.charAt(left)!=str.charAt(right)){
                    used[str.charAt(left)] = false;
                    left++;
                }
                used[str.charAt(left)] = false;
                left++;
            }
            maxLength = (maxLength>(right-left))?maxLength : (right-left);
        }
        System.out.println(maxLength);

    }
}














