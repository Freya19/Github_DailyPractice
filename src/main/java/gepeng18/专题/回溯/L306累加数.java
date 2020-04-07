package gepeng18.专题.回溯;

public class L306累加数 {
    private boolean res = false;
    // q 已经判断多少个数了
    void back(String num,int num1,int num2,int q,int deep){
        if(deep>=3&&num.length() == q)
        {
            res = true;
            return;
        }
        for(int i=q;i<num.length();){
            if(num.substring(q,i+1).length()>1&&num.charAt(q)=='0')
                return;
            Integer tmpNum = null;
            try {
                tmpNum = Integer.valueOf(num.substring(q, i + 1));

            }catch (NumberFormatException e){
                return;
            }
            if(deep<2||num1+num2==tmpNum)
                back(num,num2,tmpNum,i+1,deep+1);
            if(res || num1!=0 && num1+num2<tmpNum)
                return;
            i++;
        }
    }

    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)
            return false;
        back(num,0,0,0,0);
        return res;
    }

    public static void main(String[] args) {
        final boolean additiveNumber = new L306累加数().isAdditiveNumber("121474836472147483648");
        System.out.println(additiveNumber);
    }

}
