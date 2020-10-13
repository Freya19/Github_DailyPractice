package freya19.practice.笔试.hs;

import java.util.Iterator;

/**
 * 下压栈（能够动态调整数组大小的实现）
 */

public class DynamicStack<E> implements Iterable<E> {
    private E a[] = (E[])new Object[1]; // 栈中元素

    private int N; // 栈中元素个数

    // 2.判空
    public boolean isEmpty(){
        return N == 0;
    }

    // 3.元素个数
    public int size(){
        return N;
    }

    // 4. 调整栈的容量
    private void resize(int max){
        E[] temp = (E[])new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    // 5、 项目添入栈
    public void push(E item)
    {
        if(a.length == N) {
            resize(a.length * 2); // 如果栈满了，则将栈扩容一倍，1->2.2->4,4->8
        }
        a[N++] = item;
    }

    // 6. 删除并返回栈中的项目
    public E pop()
    {   // 从栈顶删除元素
        E item = a[--N];
        a[N] = null;
        if(N > 0 && a.length/4 == N) {
            resize(a.length/2); // 如果栈的中的元素达到了栈的1/4，则将栈容量减半
        }
        return item;
    }

    // 7. 实现迭代器
    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E>
    {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        @Override
        public E next() {
            return a[--i];
        }
        @Override
        public void remove() {}
    }

    public static void main(String[] args) {
        DynamicStack<String> stack = new DynamicStack<>();
        stack.push("数据1");
        stack.push("数据2");
        stack.push("数据3");
        for (String s : stack) {
            System.out.println(s);
        }
    }
}

