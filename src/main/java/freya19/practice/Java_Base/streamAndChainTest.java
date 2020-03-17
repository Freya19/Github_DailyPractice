package freya19.practice.Java_Base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


public class streamAndChainTest {

    //链式编程和流式计算

    @AllArgsConstructor  // 自动创建构造器
    @Data   //
    @NoArgsConstructor // 无参构造器
    @Accessors(chain = true) // 允许链式编程
    static class Book{
        private int id;
        private String bookName;
        private double price;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setBookName("java thinking");
        book.setPrice(40.5);

        Book book1 = new Book();
        book1.setPrice(35.2).setBookName("Redis").setId(2);

    }
}
