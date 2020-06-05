package freya19.practice;

//传入这样的路径——G:\2_LearnMore\06-数据库\视频\juc
// 将其下所有文件夹内的.flv文件名称更改，文件名
// 来源于.info中partName键所对的值


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

public class changeFileNameUtils {

    public void changeFileName(String srcFolderPath) {
        //通过路径得到的文件
        File folder = new File(srcFolderPath);
        // String folderName = folder.getName(); //其实是文件夹的名称（如juc）
        // System.out.println(folderName);// juc

        for (File f : folder.listFiles()) {
            String name = null;
            // 如果是文件的话，就不运行下面的
            if (f.isDirectory()) {
                for (File fs : f.listFiles()) {

                    if (StringUtils.substringAfterLast(fs.getName(), ".").equals("info")) {
                        BufferedReader is = null;
                        FileInputStream in = null;
                        try {
                            in = new FileInputStream(fs);
                            is = new BufferedReader(new InputStreamReader(in));

                            String buffer = null;
                            StringBuilder sb = new StringBuilder();

                            while ((buffer = is.readLine()) != null) {
                                sb.append(buffer);
                            }
                            String s = sb.toString();

                            String pn = "\"PartName\":\"";
                            int len = pn.length();
                            int indexOfPartName = s.indexOf(pn);

                            String lastPart = s.substring(indexOfPartName + len);
                            name = StringUtils.substringBefore(lastPart, "\"");

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
                for (File fs : f.listFiles()) {
                    if (StringUtils.substringAfterLast(fs.getName(), ".").equals("flv")) {
                        String fname = StringUtils.substringBefore(fs.getName(), ".");
                        fs.renameTo(new File(srcFolderPath + "/" + name + ".flv"));
                        //G:\2_LearnMore\06-数据库\视频\juc\
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        changeFileNameUtils cfn = new changeFileNameUtils();
        cfn.changeFileName("G:\\2_LearnMore\\06-数据库\\视频\\jvm");
    }
}
