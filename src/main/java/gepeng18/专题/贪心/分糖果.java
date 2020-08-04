package gepeng18.专题.贪心;

import java.util.Collections;
import java.util.List;

public class 分糖果 {
    int findContentChildren(List<Integer> g, List<Integer> s) {
        Collections.sort(g);
        Collections.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.size() && cookie < s.size()){
            // 糖果可以满足孩子，则糖果索引后移，孩子后移
            if (g.get(child) <= s.get(cookie)){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
