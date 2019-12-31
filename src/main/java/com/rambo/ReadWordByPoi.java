package com.rambo;

/**
 * @author baizhanshi on 2018/9/27.
 */

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWordByPoi {
    public static String getPhoneNum(String filePath, String fileName) {
        String text = "";
        String phoneNum = "";
        String realPath = filePath + "\\" + fileName;//拼接为含名字的路径
        try {
            if (fileName.endsWith(".doc")) { //doc为后缀的
                FileInputStream in;
                in = new FileInputStream(realPath);
                WordExtractor extractor = new WordExtractor(in);
                text = extractor.getText();
            }
            if (fileName.endsWith(".docx")) { //docx为后缀的
                XWPFWordExtractor docx = new XWPFWordExtractor(POIXMLDocument.openPackage(realPath));
                text = docx.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //正则表达式判断手机号
        if (!"".equals(text)) {
            Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[34578]\\d{9})|(?:861[34578]\\d{9}))(?!\\d)");
            Matcher matcher = pattern.matcher(text);
            StringBuffer bf = new StringBuffer(64);
            while (matcher.find()) {
                bf.append(matcher.group()).append(",");
            }
            int len = bf.length();
            if (len > 0) {
                bf.deleteCharAt(len - 1);
            }
            phoneNum = bf.toString();
        }
        return phoneNum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPhoneNum("D:\\log", "bb.docx"));
    }

}
