package gepeng18.专题.字符串;

import java.util.ArrayList;
import java.util.List;

public class L22括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        func(res, "", 0, 0, n);
        return res;
    }

    //
    void func(List<String> res, String thisString, int leftCount, int rightCount, int n){
        if(leftCount > n || rightCount > n || rightCount > leftCount) return ;
        if(leftCount == n && rightCount == n) {res.add(thisString); return;}
        func(res, thisString + '(', leftCount+1, rightCount, n);
        func(res, thisString + ')', leftCount, rightCount+1, n);
        return;
    }
}
