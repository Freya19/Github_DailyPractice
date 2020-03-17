package gepeng18.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class bilibiliResolver {
    static String dst = "C:\\Users\\FHY-GP\\AppData\\Local\\Packages\\36699Atelier39.forWin10_pke1vz55rvc1r\\LocalCache\\BilibiliDownload\\dst";

    public static void main(String[] args) throws Exception {
        if(!new File(dst).exists())
            new File(dst).mkdirs();

        final File wholeFolder = new File("C:\\Users\\FHY-GP\\AppData\\Local\\Packages\\36699Atelier39.forWin10_pke1vz55rvc1r\\LocalCache\\BilibiliDownload\\1415480");;
        for(File file:wholeFolder.listFiles()){
            if(file.isDirectory()){
                resolve(file);
            }
        }
    }

    private static void resolve(File folder) throws Exception {
        String partName = null;
        final String filePath = folder.getAbsolutePath();
        for(File file:folder.listFiles()){
            if(StringUtils.substringAfterLast(file.getName(),".").equals("info")) {
                partName = readInfo(file);
                break;
            }
        }

        for(File file:folder.listFiles()){
            if(StringUtils.substringAfterLast(file.getName(),".").equals("flv")) {
                file.renameTo(new File(dst+"/"+partName+".flv"));
                break;
            }
        }
    }

    private static String readInfo(File infoFile) throws Exception {
        BufferedReader bfr = new BufferedReader(new FileReader(infoFile));
        StringBuilder content = new StringBuilder();
        String buffer = null;
        while((buffer=bfr.readLine())!=null)
            content.append(buffer).append("\n");
        final JSONObject jsonObject = JSONObject.parseObject(content.toString());
        String partName = (String)jsonObject.get("PartName");
        final StringBuilder result = new StringBuilder();
        for(int i=0;i<partName.length();i++){
            if(isChinese(partName.charAt(i)))
                result.append(partName.charAt(i));
            else
                break;
        }
        return result.toString();
    }


    public static boolean isChinese(char c){
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

}
