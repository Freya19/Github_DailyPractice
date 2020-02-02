package freya19.practice.Java_Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IOChar {

    public static void main(String[] args) {
        //1、创建源
        File dest = new File("dest.txt");
        //2、选择流
        try (Writer writer = new FileWriter(dest)) {
            //3、操作(写出)
            //写法一
//			String msg ="IO is so easy\r\n尚学堂欢迎你";
//			char[] datas =msg.toCharArray(); // 字符串-->字符数组
//			writer.write(datas,0,datas.length);
            //写法二
			/*String msg ="IO is so easy\r\n尚学堂欢迎你";
			writer.write(msg);
			writer.write("add");
			writer.flush();*/

            //写法三
            writer.append("IO is so easy\r\n").append("尚学堂欢迎你");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4、释放资源
    }
}
