package com.fuicuiedu.idedemo.interview_analysis.xml;

import com.fuicuiedu.idedemo.interview_analysis.entity.Book;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Damon on 2016/11/9.
 */

public class DomBookParser {

    public List<Book> parse(InputStream is) throws Exception {
        List<Book> books = new ArrayList<>();
        //取得DocumentBuilderFactory实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //从factory获取DocumentBuilder实例
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析输入流 得到Document实例
        Document doc = builder.parse(is);
        //获取Document中所有要素
        Element rootElement = doc.getDocumentElement();
        //获取元素中的节点列表
        NodeList items = rootElement.getElementsByTagName("book");
        for (int i = 0; i < items.getLength(); i++) {
            Book book = new Book();
            Node item = items.item(i);
            //获取节点的子节点列表
            NodeList properties = item.getChildNodes();
            for (int j = 0; j < properties.getLength(); j++) {
                Node property = properties.item(j);
                //获取节点名称
                String nodeName = property.getNodeName();
                if (nodeName.equals("id")) {
                    book.setId(Integer.parseInt(property.getFirstChild().getNodeValue()));
                } else if (nodeName.equals("name")) {
                    book.setName(property.getFirstChild().getNodeValue());
                } else if (nodeName.equals("price")) {
                    book.setPrice(Float.parseFloat(property.getFirstChild().getNodeValue()));
                }
            }
            books.add(book);
        }
        return books;
    }
}
