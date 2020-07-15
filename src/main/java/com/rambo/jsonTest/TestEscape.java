package com.rambo.jsonTest;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/9 11:10
 */


public class TestEscape {
    public static void main(String[] args) {
        String str = "thi is a test 这是一个测试";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<persons>\n" +
                "   <person id=\"23\">\n" +
                "         <name>张   三</name>\n" +
                "         <age>26</age>\n" +
                "  </person>\n" +
                "  <person id=\"22\">\n" +
                "        <name>李四</name>\n" +
                "        <age>25</age>\n" +
                " </person>\n" +
                "</persons>";

        System.out.println("用escapeJava方法转义之后的字符串为:" + StringEscapeUtils.escapeJava(str));

        System.out.println("用unescapeJava方法反转义之后的字符串为:" + StringEscapeUtils.unescapeJava(str));


        System.out.println("用escapeHtml方法转义之后的字符串为:" + StringEscapeUtils.escapeHtml(str));

        System.out.println("用unescapeHtml方法反转义之后的字符串为:" + StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str)));


        System.out.println("用escapeXml方法转义之后的字符串为:" + StringEscapeUtils.escapeXml(xml));

        System.out.println("用unescapeXml方法反转义之后的字符串为:" + StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml(xml)));


        System.out.println("用escapeJavaScript方法转义之后的字符串为:" + StringEscapeUtils.escapeJavaScript(str));

        System.out.println("用unescapeJavaScript方法反转义之后的字符串为:" + StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.unescapeJavaScript(str)));
    }
}