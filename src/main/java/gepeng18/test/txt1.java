package gepeng18.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class txt1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String[] splits = s.split(" ");
            final List<String> strings = Arrays.asList(splits);
            Collections.sort(strings);
            for(int i=0;i<strings.size();i++){
                if(i!=strings.size()-1)
                    System.out.print(strings.get(i)+" ");
                else
                    System.out.println(strings.get(i));

            }
        }


    }


}