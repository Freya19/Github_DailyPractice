package freya19.practice.JavaCode;

import java.util.*;

/*
存储表格数据 ROM 使用Map 和 List
 */
public class testTableDataStore {
    public static void main(String[] args) {
        //创建Map存放表格数据的  每一行  的内容
        Map<String,Object> row1 = new HashMap<String,Object>();
        row1.put("学号",1001);
        row1.put("姓名","张三");
        row1.put("薪水",10000);
        row1.put("城市","北京");

        Map<String,Object> row2 = new HashMap<String,Object>();
        row2.put("学号",1002);
        row2.put("姓名","李四");
        row2.put("薪水",30000);
        row2.put("城市","上海");

        Map<String,Object> row3 = new HashMap<String,Object>();
        row3.put("学号",1003);
        row3.put("姓名","王五");
        row3.put("薪水",8000);
        row3.put("城市","合肥");

        //创建List存放每一个Map
        List<Map<String,Object>> table = new ArrayList<Map<String,Object>>();
        table.add(row1);
        table.add(row2);
        table.add(row3);

        //增强for循环来遍历
        for(Map<String,Object> row:table){
            //获取每一行的key，保存在set中
            Set<String> keyset = row.keySet();
            System.out.println(keyset);

            for(String key:keyset){
                System.out.print(key+"---"+row.get(key)+"\t");
            }
            System.out.println();
        }
    }
}

//写的真棒
