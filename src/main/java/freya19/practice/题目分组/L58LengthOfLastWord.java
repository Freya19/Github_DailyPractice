package freya19.practice.题目分组;
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。

示例:
输入: "Hello World"
输出: 5

 */
public class L58LengthOfLastWord {
    public int lengthOfLastWord(String s){
        int len = 0;
        if(s!=null && s.length()!=0) {
            String[] arr = s.split("\\s+"); // \转义字符 \s+ 表示匹配所有的空字符
            if(arr.length!=0) {
                String lastWord = arr[arr.length - 1];
                len = lastWord.length();
                return len;
            }
        }
        return 0;
    }
    /*
    int len = 0;
        String[] arr = s.split("\\s+"); // \转义字符 \s+ 表示匹配所有的空字符
        String lastWord = arr[arr.length-1];
        len = lastWord.length();
        return len;

    提交上面的内容给LeetCode会出错：
    执行出错信息： Line 5: java.lang.ArrayIndexOutOfBoundsException: -1
    最后执行的输入： " "
     */


    public static void main(String[] args) {
        String str = "Hello World Fighting WuHan";
        String str1 = " ";
        String str2 = "";

        System.out.println(str1.isEmpty()); // false
        System.out.println(str2.isEmpty()); // true
        System.out.println(str1.length());  // 1  所以不能用非空和长度不等于0来判断
        System.out.println(str2.length());  // 0 所以不能用非空和长度不等于0来判断

        L58LengthOfLastWord lolw = new L58LengthOfLastWord();
        int l = lolw.lengthOfLastWord(str1);
        System.out.println(l);

    }

}

/*
补充："\\s+" 正则表达式

正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]

    \f -> 匹配一个换页
    \n -> 匹配一个换行符
    \r -> 匹配一个回车符
    \t -> 匹配一个制表符
    \v -> 匹配一个垂直制表符

而“\s+”则表示匹配任意多个上面的字符。另因为反斜杠在Java里是转义字符，所以在Java里，我们要这么用“\\s+”.
比如，当碰到想用空格来分割字符串时，就可以这样写： String[] s = str.split("\\s+")
 */