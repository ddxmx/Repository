package com.test.factory;

import com.test.ioc.Book;

/**
 * 非静态工厂类
 */
public class BookFactory {
    public Book getBook(){
        return new Book();
    }
}
