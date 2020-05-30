package gepeng18.test;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

class Demo implements Runnable {

    @Override
    public void run() {

    }
}
public class testHashMap {
    public static void main(String[] args) {

        new Thread(new Demo()).start();
    }
}
