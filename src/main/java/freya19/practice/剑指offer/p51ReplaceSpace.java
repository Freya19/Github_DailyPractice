package freya19.practice.剑指offer;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class p51ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        if (str.toString().equals("")) return "";

        //计算字符串中空格的数量
        int start = 0;
        int spaceNums = 0;
        while (start < str.length()) {
            if (str.charAt(start) == ' ') {
                spaceNums++;
            }
            start++;
        }

        //利用替换%20之后字符串的长度开辟新的字符串数组
        int p2 = str.length() + spaceNums * 2 - 1;
        int p1 = str.length() - 1;
        StringBuilder res = new StringBuilder(p2); //长度为p2的字符串数组

        //原字符串先赋值到新字符串数组中
        res.append(str);

        //p2-p1之间空的区域加一个数字，以免对原来的空格数量产生影响
        for (int i = 0; i < p2 - p1; i++)
            res.append('1');

        while (p1 >= 0) {
            //p1向前遍历，遇到空格，p2就填充 % 2 0 三个字符
            if (res.charAt(p1) == ' ') {
                res.setCharAt(p2, '0');
                res.setCharAt(p2 - 1, '2');
                res.setCharAt(p2 - 2, '%');
                p2 = p2 - 3;
                p1 = p1 - 1;
            } else { // p1不是空格时，将p1处的字符复制给p2处，然后p1和p2向前移动；
                res.setCharAt(p2, res.charAt(p1));
                p1--;
                p2--;
            }
        }
        return res.toString();
    }

    //    public static void main(String[] args) {
//        StringBuffer s = new StringBuffer("we are family");
//        p51ReplaceSpace rs=new p51ReplaceSpace();
//        System.out.println(rs.replaceSpace(s));
//
//    }
    public static void main(String[] args) {
        final String we_are_happy = replaceSpace(new StringBuffer("we are happy"));
        System.out.println(we_are_happy);
    }
}
