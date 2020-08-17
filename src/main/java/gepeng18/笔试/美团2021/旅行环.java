package gepeng18.笔试.美团2021;

import java.util.Currency;
import java.util.Stack;

// 1 2 , 2 3 , 3 1  每次都入栈，栈中正好有相同的则弹出
// 第一步 1进去    栈中 1
// 第二步 2进去    栈中 2
// 第三步 2进去时，发现peek是2，则里面的2出来   栈中 1
// 第四步 3进去                              栈中 1  3
// 第五步 3进去时，发现peek是3，则里面的3出来   栈中 1
// 第六步 1进去时，发现peek是1，则里面的1出来   栈中 空，每次没空则表明出现了环，则cycle++

public class 旅行环 {
    public int solve(String [] paths){
        int cycle = 0;
        Stack<String> stack = new Stack<>();
        for (String path:paths){
            String[] split = path.split(",");

            for (int i = 0;i<split.length;i++){
                // 如果栈中有数据，则判断相等时弹出，不相等则插入
                // 如果栈中无数据，则加入
                if(stack.size()!=0){
                    if(stack.peek().equals(split[i]) )
                        stack.pop();
                    else
                        stack.push(split[i]);
                }else{
                    stack.push(split[i]);
                }
            }
            if (stack.size()==0)
                cycle++;
        }
        return cycle;
    }

    public static void main(String[] args) {
        旅行环 solve = new 旅行环();
        int i = solve.solve(new String[]{"beijing,shanghai",
                "shanghai,guangzhou",
        "guangzhou,shenzhen",
        "shenzhen,beijing",
        "hefei,nanjing",
        "nanjing,hefei"});
        System.out.println(i);
        int j = solve.solve(new String[]{"beijing,beijing"});
        System.out.println(j);
    }
}
