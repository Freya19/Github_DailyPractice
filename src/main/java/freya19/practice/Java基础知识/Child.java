package freya19.practice.Java基础知识;

import java.util.ArrayList;

public class Child extends Father {

    private String school;

    public String getSchool() {
        return school;
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.getSchool();
    }

}
