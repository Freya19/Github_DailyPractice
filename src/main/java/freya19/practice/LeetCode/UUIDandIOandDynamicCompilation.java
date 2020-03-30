package freya19.practice.LeetCode;

import java.io.*;
import java.util.UUID;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/*
题目：
    通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后调用动态编译方法！
要求：
    1. 字符串存到文件并编译运行
    2. 改名字为随机字符串
    3. 删除中间文件
 */

public class UUIDandIOandDynamicCompilation { //涉及动态编译、UUID和IO流

        public static void main(String[] args) throws Exception {
            String str = "public class Hi {public static void main(String[] args){System.out.println(\"haha,111!\");}}";
//        System.out.println(str);

            //二、将名字改为随机字符串
            String uuid = UUID.randomUUID().toString();
            //  类名： 不能有 -  、首字母不能数字
            String u = uuid.replaceAll("-","");
            String newClassName = "a"+u;
//        System.out.println("由UUID改编后得到的随机类名：" + newClassName);

            String newFileContent =
                    str.replaceAll("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*", //不要动正则里的任何一个东西哦
                            "class "+ newClassName+" ");
//        System.out.println("str中替换类名后得到的str："+newFileContent);

            //一、 字符串存到文件中
            File file = new File("G:/demo-temp/"+ newClassName+".java");
            System.out.println(file.getAbsolutePath());
//        System.out.println("file的全路径: "+ file.getAbsolutePath());
            FileOutputStream src = new FileOutputStream(file);
            src.write(newFileContent.getBytes());
            src.flush();

            // 编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//      int result = compiler.run(null, null, null, "G:\\demo-temp\\src\\main\\java\\Hello.java");
            int result = compiler.run(null, null, null,
                    "G:/demo-temp/"+ newClassName + ".java" );
            System.out.println(result==0?"编译成功":"编译失败");

            //通过Runtime调用执行类
            Runtime run = Runtime.getRuntime();
//      Process process = run.exec("java -cp  G:\\demo-temp\\src\\main\\java Hello");
            Process process = run.exec("java -cp G:/demo-temp "+ newClassName ); //空格

            InputStream in = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String info = "";
            while((info=reader.readLine())!=null){
                System.out.println(info);
            }

            //三、释放资源、删除中间类文件
            try {
                if (src != null) src.close();
                file.delete();

                File fileClass = new File("G:/demo-temp/" + newClassName + ".class");
                fileClass.delete();
            }catch (IOException e){
                e.printStackTrace();
            }

//         // 三、调用动态编译，并删除中间文件类（xx.class文件）
//        Execular exc = new Execular();
//        exc.init(file);

        }

//    // 动态编译过程
//    public void init(File f) throws Exception{
//        //编译
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
////      int result = compiler.run(null, null, null, "G:\\demo-temp\\src\\main\\java\\Hello.java");
//        int result = compiler.run(null, null, null, f.getAbsolutePath());
//        System.out.println(result==0?"编译成功":"编译失败");
//
//        String fileClassPath = f.getAbsolutePath().replaceAll(".java","");
//        System.out.println("编译后得到的类文件路径："+ fileClassPath);
//
//        //通过Runtime调用执行类
//        Runtime run = Runtime.getRuntime();
////      Process process = run.exec("java -cp  G:\\demo-temp\\src\\main\\java Hello");
//        Process process = run.exec("java -cp  "+ fileClassPath );
//
//        InputStream in = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        String info = "";
//        while((info=reader.readLine())!=null){
//            System.out.println(info);
//        }
//
//    }


}
