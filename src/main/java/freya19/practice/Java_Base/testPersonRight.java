package freya19.practice.Java_Base;

public class testPersonRight {
    public static void main(String[] arg){
        Person p = new Person();
        p.setName("Freya");
        p.setAge(0);
    }
}

class Person {
    // 下面这些属性都设置成私有权限，除了本类其他都不可以访问
    private int id;
    private String name;
    private int age;
    private boolean male;

    // 要想在类外访问上述属性，通过get或set方法实现
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        if(age>=1&&age<=120) {
            this.age = age;
        }else{
            System.out.println("请输入正常的年龄！！");
        }
    }
}
