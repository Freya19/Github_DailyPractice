package gepeng18.笔试.华为2016校园招聘上机笔试题;

import javax.print.attribute.standard.MediaSizeName;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 *
 * 输入描述:
 *
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 *     文件路径为windows格式
 *
 *     如：E:\V1R2\product\fpgadrive.c 1325
 *
 *
 * 输出描述:
 *
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *
 *     结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *
 *     如果超过8条记录，则只输出前8条记录.
 *
 *     如果文件名的长度超过16个字符，则只输出后16个字符
 *
 *
 * 输入例子1:
 *
 * E:\V1R2\product\fpgadrive.c 1325
 *
 *
 * 输出例子1:
 *
 * fpgadrive.c 1325 1
 */
public class 简单错误记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap();
        while (in.hasNext()){

            String error = in.next();
            int lineNum = in.nextInt();

            if(map.size() < 8) {
                int index = error.lastIndexOf("\\");
                if(index==-1)
                    index = 0;
                else
                    index = index+1;
                error = error.substring(index);
                map.put(error,map.getOrDefault(error+"_"+lineNum,0)+1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry:entries){
            final String errorAndLineNum = entry.getKey();
            String[] split = errorAndLineNum.split("_");
            String errorMsg = split[0];
            if (errorMsg.length()>16)
                System.out.print(errorMsg.substring(errorMsg.length()-16));
            else
                System.out.print(errorMsg);
            System.out.println(split[1]);
            System.out.println(entry.getValue());
        }

    }
}
