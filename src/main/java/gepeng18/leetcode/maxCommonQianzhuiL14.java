package gepeng18.leetcode;

/*
*
* 编写一个函数来查找字符串数组中的最长公共前缀。
*
如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"

示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */

class SolutionL14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLength = Math.min(minLength,strs[i].length());
        }
        if(minLength==0){
            return "";
        }
        char firstChar = strs[0].charAt(0);
        for(int i=1;i<strs.length;i++){
            if(strs[i].charAt(0)!=firstChar){
                return "";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strs[0].charAt(0));
        for(int j=1;j<minLength;j++){
            char c = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++)
            {
                if (c !=strs[i].charAt(j))
                    return stringBuilder.toString();
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
public class maxCommonQianzhuiL14 {
    public static void main(String[] args) {
        String[] strs = {"123","123","1234"};
        String resutl = new SolutionL14().longestCommonPrefix(strs);
        System.out.println(resutl);
    }
}
