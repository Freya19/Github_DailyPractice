package gepeng18.practice.idea;

import com.sun.media.sound.SoftTuning;

import java.util.Random;

public class subString {

    public static void main(String[] args) {
        String string = "abcdefghigklmonpqrstuvwxyz";
        String substring = string.substring(0, 26);
        System.out.println(substring);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            int start = random.nextInt(26);
            int length = start>21?26-start:5;
            System.out.println(string.substring(start,start+length));
        }
    }
}
