package gepeng18.笔试.模拟考试.注解;


@ClassAno("GepengClass")
public class Entity {
    private String name;

    @MethodAno("GepengMethod")
    void print(){

    }

    void print(String p){
        System.out.println("这是代参数的调用 "+name+" "+ p);
    }
}
