package gepeng18.专题.括号题;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */

/**
 * 题解：
 *
 *  设 ( = 1 , ) = -1
 *  括号序列合法 == 所有的前缀和cnt >=0且总和等于0
 *
 *  start 当前枚举过程中的开头
 *  cnt 前缀和
 *
 *  滑动窗口题，>=0对我们都有利(=0最好，>0则还有生还的可能,=0就死道临头
 *
 *
 * 那么就存在三种情况：
 * 1、cnt < 0  -> 左边右移
 * 2、cnt>0    -> 右边右移
 * 3、cnt==0   -> [左边,右边] 是一段合法的括号序列 如()是合法序列，
 *                  则左边不动，右边继续向右看是否能找到类似于()()这样的情况，这也是合法情况且长度更大
 *
 * 注意：这时候，当遇到 (() 这种情况就失效了
 * 所以我们还需要反着做一遍
 */
public class L32最长有效括号 {
    public int find(String s ){
        //目前有效的滑动窗口的初始位置
        int start = 0;
        //目前从start开始的值得总和
        int cnt = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                cnt++;
            }
            else{
                cnt--;
                if(cnt<0){
                    start = i+1;
                    cnt=0;
                }else if(cnt==0){
                    res = Math.max(res,i-start+1);
                }
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        int res = find(s);
        final String orderReverse = new StringBuilder(s).reverse().toString();
        StringBuilder orderAndCharReverse = new StringBuilder();
        for(int i=0;i<orderReverse.length();i++){
            if(orderReverse.charAt(i)==')'){
                orderAndCharReverse.append("(");
            }
            else{
                orderAndCharReverse.append(")");
            }
        }
        res = Math.max(res,find(orderAndCharReverse.toString()));
        return res;
    }

}
