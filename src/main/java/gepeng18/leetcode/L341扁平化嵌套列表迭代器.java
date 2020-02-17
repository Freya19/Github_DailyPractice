package gepeng18.leetcode;

import java.util.*;

interface NestedInteger {
 // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
 // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();
 // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class L341扁平化嵌套列表迭代器 implements Iterator<Integer> {
    LinkedList<Integer> res ;
    public L341扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        res = new LinkedList<>();
        if(!nestedList.isEmpty()){
            for (int i = 0; i < nestedList.size(); i++) {
                parseData(nestedList.get(i));
            }
        }
    }

    void parseData(NestedInteger item) {
        if (item.isInteger()) {
            res.push(item.getInteger());
        } else {
            final List<NestedInteger> list = item.getList();
            for (int i = 0; i < list.size(); i++) {
                parseData(list.get(i));
            }
        }
    }


    @Override
    public Integer next() {
        return res.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !res.isEmpty();
    }
}
