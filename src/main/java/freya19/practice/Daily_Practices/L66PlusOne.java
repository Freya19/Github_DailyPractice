package freya19.practice.Daily_Practices;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class L66PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
   /* public int[] plusOne(int[] digits) {
        if(digits!=null&&digits.length!=0){
            int len = digits.length;
            digits[len-1]+=1;

            if(digits[len-1]<10) return digits; //如果0-8之间（也就是+1之后为1-9之间）
            else { //原数组末位为9 ，加1 后等于10 ——> 新数组中为 1,0
                int l = len+1;//新数组要扩容，这是它的长度
                int[] nd = new int[l]; //新数组
                for(int i = 0;i<len-1;i++){ //前面len-1个元素是一样的
                   nd[i] = digits[i];//直接赋值过去
                }
                //末位两个是固定的了
                nd[l-2]=1;
                nd[l-1]=0;
                return nd;
            }
        }
        //为空的情况下，返回空
        int[] n =new int[0];
        return n;
    }   */

    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {0};
        int[] a3 = {};
        int[] a4 = {1,2,3,9};
        int[] a5 = {9,9}; //输出要是[1,0,0]  为啥呢？？？？？ 因为99+1 = 100.。。。

//        System.out.println(a3==null); //false  ——> 数组为空是这样定义的：int[] a = null;是创建了数组的引用，但在堆中并没有数组中的元素
//        System.out.println(a3.length==0);//true

        L66PlusOne po = new L66PlusOne();
        po.plusOne(a1);
//        po.plusOne(a2);
//        po.plusOne(a3);
//        po.plusOne(a4);
//        po.plusOne(a5);
    }
}
