package gepeng18.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class 计算split平均数 {
    public static void readFileByLines() throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        List<Float> list = new ArrayList<>();
        str = br.readLine();
        while(!str.equals("")) {
             Float num = Float.valueOf(str.split(":")[1].trim());
             list.add(num);
             str = br.readLine();
        }
        float sum = 0;
        for(float num:list){
            sum+=num;
        }
        float average = sum/list.size();
        System.out.println(list);
        System.out.println(average);
    }

    public static void main(String[] args) throws IOException {
        计算split平均数.readFileByLines();
        
    }
}

/**
joint_fine_tune  split 1 :  91.66667
joint_fine_tune  split 2 :  77.083336
joint_fine_tune  split 3 :  77.083336
joint_fine_tune  split 4 :  77.083336
joint_fine_tune  split 6 :  79.16667
joint_fine_tune  split 8 :  85.41667
joint_fine_tune  split 9 :  81.25
joint_fine_tune  split 10 :  91.66667
 */