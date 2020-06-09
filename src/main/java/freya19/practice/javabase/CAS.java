package freya19.practice.javabase;
/*
    原文链接：https://blog.csdn.net/u010730731/java/article/details/89004629
 */
public class CAS {
        Object value;

        Object getValue(){
            return this.value;
        }

        void setValue(Object obj){
            this.value=obj;
        }

        boolean compareAndSwap(Object localValue,Object newValue){
            if(this.getValue().equals(localValue)){
                setValue(newValue);
                return true;
            }else{
                return false;
            }
        }
}
