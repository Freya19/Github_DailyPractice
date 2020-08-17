package freya19.practice.Java基础知识;

public class Father {
    private String name;
    private int age;

    private int plusOne(int num) {
        return num + 1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
