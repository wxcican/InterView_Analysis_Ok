package com.fuicuiedu.idedemo.interview_analysis.xml;

import android.util.Xml;

import com.fuicuiedu.idedemo.interview_analysis.entity.Book;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damon on 2016/11/9.
 */

public class PullBookParser {

    public List<Book> parse(InputStream is) throws Exception {
        List<Book> books = null;
        Book book = null;

        //由android.util.Xml创建一个XmlPullParser实例
        XmlPullParser parser = Xml.newPullParser();
        //设置输入流 并指明编码方式
        parser.setInput(is, "UTF-8");

        //我们需要自己获取产生的事件然后做相应的操做
        int eventType = parser.getEventType();
        //判断事件类型做相应的操作
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    books = new ArrayList<Book>();
                    break;
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals("book")) {
                        book = new Book();
                    } else if (parser.getName().equals("id")) {
                        eventType = parser.next();
                        book.setId(Integer.parseInt(parser.getText()));
                    } else if (parser.getName().equals("name")) {
                        eventType = parser.next();
                        book.setName(parser.getText());
                    } else if (parser.getName().equals("price")) {
                        eventType = parser.next();
                        book.setPrice(Float.parseFloat(parser.getText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("book")) {
                        books.add(book);
                        book = null;
                    }
                    break;
            }
            //判断是否还有下一个事件，有则循环
            eventType = parser.next();
        }
        return books;
    }
}
