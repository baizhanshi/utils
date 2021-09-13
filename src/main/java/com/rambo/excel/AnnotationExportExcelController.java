package com.rambo.excel;


import com.rambo.excel.ExportExcelWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/13 19:39
 */
@Controller
@RequestMapping(value = "/export")
public class AnnotationExportExcelController {

    /**
     * 注解方式导出
     * @param response
     * @throws Exception
     */
    @RequestMapping("/annotation")
    public void getAnnotationExcel(HttpServletResponse response) throws Exception {
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Student("00" + i, "张三", "001", 100, "篮球"));
        }
        String fileName = "annotation_excel";
        ExportExcelWrapper<Student> wrapper = new ExportExcelWrapper<>();
        wrapper.annotationExportExcel(fileName, fileName, list, Student.class, response, ExportExcelWrapper.EXCEL_FILE_2003);
    }

    /**
     * 直接导出
     * @param response
     * @throws Exception
     */
    @RequestMapping("/web")
    public void getWebExcel(HttpServletResponse response) throws Exception {
        // 准备数据
        List<Animal> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Animal(111, "张三", "男"));
            list.add(new Animal(111, "李四", "男"));
            list.add(new Animal(111, "王五", "女"));
        }
        String[] columnNames = {"ID", "姓名", " 性别"};
        String fileName = "web_excel";
        ExportExcelWrapper<Animal> util = new ExportExcelWrapper<>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelWrapper.EXCEL_FILE_2003);
    }
}