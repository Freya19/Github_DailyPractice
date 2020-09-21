package gepeng18.面试.IO.简易版本;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1008);
        while (true){
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String data;
            while ((data = reader.readLine())!=null){
                System.out.println(data);
                writer.write(data+"\n");
                writer.flush();
            }
        }

    }

}
