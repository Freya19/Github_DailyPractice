package gepeng18.面试.IO.简易版本;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1008);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner in = new Scanner(System.in);
        while (true){
            String data = in.nextLine().trim();
            if (!data.equals("quit")){
                writer.write(data+"\n");   // \n 一定需要
                writer.flush();
                // 读取服务器返回的消息
                String msg = reader.readLine();
                System.out.println(msg);
            }
        }

    }
}
