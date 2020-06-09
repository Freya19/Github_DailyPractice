package freya19.practice.javabase;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

    /**
     * 文件字节输出流
     *1、创建源
     *2、选择流
     *3、操作(写出内容)
     *4、释放资源
     *  @author 裴新
     *
     */
public class IO{

        public static void main(String[] args) {
            //1、创建源
            File dest = new File("dest.txt");
            //2、选择流
            try (OutputStream os = new FileOutputStream(dest, true)) {
                //3、操作(写出)
                String msg = "IO is so easy\r\n";
                byte[] datas = msg.getBytes(); // 字符串-->字节数组(编码)
                os.write(datas, 0, datas.length);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //4、释放资源
        }
}
