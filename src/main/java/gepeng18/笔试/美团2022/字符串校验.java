package gepeng18.笔试.美团2022;

/**
 * 2021届秋招美团笔试
 * 字符串检查：
 * 1、第一个必须是大小写字母；
 * 2、只能包含字母和数字
 * 3、字母和数字分别至少有一个
 */
public class 字符串校验 {

    public static boolean solve(String s){
        if(s.length()<0)
            return false;
        if (!Character.isAlphabetic(s.charAt(0)))
            return false;
        int alphabetNum = 0;
        int numberNum = 0;
        for (int i =0;i<s.length();i++){
            if (Character.isAlphabetic(s.charAt(i)))
                alphabetNum++;
            else if(Character.isDigit(s.charAt(i)))
                numberNum++;
            else
                return false;
        }
        return alphabetNum>0 && numberNum>0;
    }

    public static void main(String[] args) {
        boolean solve = solve("aab0");
        System.out.println(solve);
    }

}
