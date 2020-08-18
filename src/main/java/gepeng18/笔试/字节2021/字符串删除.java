package gepeng18.笔试.字节2021;

/**
 * 问一个字符串里至少要删去几个字符可以使该字符串不包含“0010”。
 * 没做出来。。。后来讨论区里说只要找有几个“0010”即可，仔细想想确实是，比如00100010至少删去两个字符，0010010至少删去两个字符，001010至少删去一个字符。
 */
public class 字符串删除 {
    public static int solve(String string,String sub){
        int num = 0;
        int index = string.indexOf(sub);
        while (index!=-1){
            num++;
            index = string.indexOf(sub,index+sub.length());
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(字符串删除.solve("00100010", "0010"));
        System.out.println(字符串删除.solve("0010010", "0010"));
        System.out.println(字符串删除.solve("001010", "0010"));


    }
}
