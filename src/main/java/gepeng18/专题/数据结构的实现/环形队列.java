package gepeng18.专题.数据结构的实现;

public class 环形队列 {
    private Object [] tables;
    private int tail = -1;
    private int head = 0;
    private int length;
    public 环形队列(int num) {
        tables = new Object[num];
        length = num;
    }

    public void put (Object i){
        if (head!=tail){
            tables[head] = i;
            head = (head+1)%length;
        }else
            System.out.println("已满");
    }

    public Object get (){

        if (head!=(tail +1)%length){
            tail = (tail +1)%length;
            return tables[tail];
        }else
            System.out.println("已空");
        return null;
    }
}
