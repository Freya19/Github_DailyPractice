import java.util.Scanner;

public class passwd {
    public static void solve(String s){
        boolean hasNumber = false;
        boolean hasUp = false;
        boolean hasLow = false;
        boolean hasFuhao = false;

        for (int i = 0;i<s.length();i++)
            if (Character.isDigit(s.charAt(i)))
                hasNumber = true;
            else if (Character.isLowerCase(s.charAt(i)))
                hasLow = true;
            else if (Character.isUpperCase(s.charAt(i)))
                hasUp = true;
            else
                hasFuhao = true;
        if (s.length()>=8 && s.length()<=120)
            System.out.println(1);
        else if (hasFuhao && hasLow && hasNumber && hasUp)
            System.out.println(0);
        else
            System.out.println(1);

    }

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine().trim();
        String[] splits = s.split(" ");
        for (String split:splits)
            solve(split);
    }
}
