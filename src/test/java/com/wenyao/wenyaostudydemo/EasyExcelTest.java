package com.wenyao.wenyaostudydemo;

import java.util.List;

import org.junit.Test;
import org.testng.collections.Lists;

import com.alibaba.excel.EasyExcel;
import com.wenyao.wenyaostudydemo.excel.ExcelData;

public class EasyExcelTest extends BaseTest {

    @Test
    public void simpleWrite() {
        // 写法1
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelData.class).sheet("模板").doWrite(getExcelData());

        // // 写法2
        // fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // // 这里 需要指定写用哪个class去写
        // ExcelWriter excelWriter = EasyExcel.write(fileName, ExcelData.class).build();
        // WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        // excelWriter.write(getExcelData(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        // excelWriter.finish();
    }

    @Test
    public void templateWrite() {
        String templateFileName =
                "/Users/wenyao/workspace/wenyaoworkspace/wenyao-study-demo/src/main/resources/demo.xlsx";
        String fileName = "templateWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ExcelData.class)
                .withTemplate(templateFileName)
                .needHead(Boolean.FALSE)
                .sheet()
                .doWrite(getExcelData());
    }

    private List<ExcelData> getExcelData() {
        List<ExcelData> excelList = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            excelList.add(new ExcelData(i, "wenyao"));
        }
        return excelList;
    }
}
