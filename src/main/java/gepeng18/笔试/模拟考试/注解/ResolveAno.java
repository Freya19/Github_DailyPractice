package gepeng18.笔试.模拟考试.注解;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResolveAno {
    public static void main(String[] args) {
        try {
            Class<?> entityClass = Class.forName("gepeng18.笔试.模拟考试.注解.Entity");
            ClassAno classAno = entityClass.getAnnotation(ClassAno.class);
            if(classAno!=null){
                // todo
                System.out.println(classAno.value());
            }

            //all
            Method printMethod1 = entityClass.getDeclaredMethod("print");
            printMethod1.setAccessible(true);

            Method printMethod2 = entityClass.getDeclaredMethod("print",String.class);
            printMethod2.setAccessible(true);

            //public
//            Method printMethod3 = entityClass.getMethod("print",String.class);
//            printMethod3.setAccessible(true);

            //注解
            MethodAno methodAno = printMethod2.getAnnotation(MethodAno.class);

            if(methodAno!=null){
                // todo
                System.out.println(methodAno.value());
            }


            entityClass.newInstance(); //无参
//            entityClass.getConstructor(String.class).newInstance() ; //有string参的

            //函数调用
            Object entity = entityClass.newInstance();
            Field nameField = entityClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(entity,"GP");
            printMethod2.invoke(entity,"无用的参数");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
