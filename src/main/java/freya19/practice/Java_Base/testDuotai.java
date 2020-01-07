package site.pyyf.practice;

public class testDuotai {
    public  /*static*/ void main(String[] arg){
        Animal a = new Animal();

    }

    class Animal {
        public void shout() {
            System.out.println("Animal 叫了一声！");
        }
    }
    class Dog extends Animal {
        public void shout() {
            System.out.println("狗：旺旺旺！");
        }
        public void seeDoor() {
            System.out.println("看门狗：看门中....");
        }
    }
    class Cat extends Animal {
        public void shout() {
            System.out.println("猫：喵喵喵喵！");
        }
    }
}
