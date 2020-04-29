package gepeng18.专题.数据结构的实现;
import java.util.HashMap;

/**
 * 手动实现一个HashSet，更深刻理解HashSet底层原理
 * @author 高淇
 *
 */
public class MyHashSet {

    HashMap map;

    private static final Object  PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public  int  size(){
        return  map.size();
    }

    public void add(Object o){
        map.put(o, PRESENT);
    }

    @Override
    public String toString() {

        StringBuilder   sb = new StringBuilder();
        sb.append("[");

        for(Object key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return  sb.toString();

    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        System.out.println(set);

    }

}

