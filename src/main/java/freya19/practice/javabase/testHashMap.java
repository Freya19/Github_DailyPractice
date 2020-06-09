//package freya19.practice.Java_Base;
//
//public class testHashMap {
//    Node[] table;  // HashMap中的 位桶数组
//    int size;
//
//
//    public testHashMap(){
//        table = new Node[16]; //数组的长度一般为2的整数幂
//    }
//
//    // 添加元素的方法
//    public void put(Object key, Object value){
//        // 定义新节点对象
//        Node newNode = new Node();
//        newNode.hash=myHash(key.hashCode(),table.length);
//        newNode.key=key;
//        newNode.value=value;
//        newNode.next=null;
//
//        Node temp = table[newNode.hash];
//        Node last = null; //正在遍历的最后一个元素
//        boolean keyRepeat = false;
//
//        if(temp == null){
//            //此处数组为空，直接将新节点放进去
//            table[newNode.hash]=newNode;
//        }else{
//            //此处数组非空，则遍历对应的链表
//            while(temp!=null){
//                //key如果重复，则覆盖
//                if(temp.key.equals(key)){
//                    keyRepeat=true;
//                    System.out.println("key 重复了");
//                    temp.value=value;// value覆盖，hash、key和next都不变
//                    break;
//                }else{
//                    //key 不重复 则遍历下一个
//                    //要先将temp保存先
//                    last=temp;
//                    temp=temp.next;
//                }
//            }
//            if(!keyRepeat){
//                last.next=newNode;
//            }
//        }
//    }
//
//    public static int myHash(int v, int length){
//        //这个方法是为了返回hash，而这个hash计算时通过 value/长度-1
//        System.out.println("hash in myHash:"+(v&(length-1)));     //位运算，效率高
//        System.out.println("hash in myHash:"+(v%(length-1)));     //取模运算，效率低
//        return v&(length-1);
//    }
//
//
//    public static void main(String[] args) {
//        testHashMap hm = new testHashMap();
//        hm.put(10,'A');
//        hm.put(20,'B');
//        hm.put(30,'C');
//
//        hm.put(53,"I");
//        hm.put(69,"LOVE");
//        hm.put(85,"U");
//
//        System.out.println(hm);
//
//        //找到重复的hash
//        //for(int i =0;i<100;i++){
//          //  System.out.println(i+"------"+myHash(i,16));
//        //}
//    }
//}
