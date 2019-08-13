package com.wenyao.wenyaostudydemo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.setting.dialect.Props;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

public class HutoolDemoTest extends BaseTest {

    @Test
    public void hutoolTest() throws IOException {
        BufferedInputStream inputStream = FileUtil.getInputStream("C:\\Users\\Think\\Desktop\\test.txt");
        BufferedOutputStream outputStream =
                FileUtil.getOutputStream(FileUtil.newFile("C:\\Users\\Think\\Desktop\\test2.txt"));
        long copy = IoUtil.copy(inputStream, outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
        BufferedReader bufferedReader = IoUtil.getReader(inputStream, Charset.defaultCharset());
        int readLine = bufferedReader.read();
        Console.log(readLine);
        Props props = new Props("application.properties");
        Console.log(props);
        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("city", "成都");
        String string = HttpUtil.get("www.baidu.com", objectObjectHashMap);
        Console.log(string);

        // 带进度显示的文件下载
        HttpUtil.downloadFile("http://dubbo.apache.org/zh-cn/docs/user/quick-start.html",
                FileUtil.file("e:/wenyaodownload"), new StreamProgress() {

                    @Override
                    public void start() {
                        Console.log("开始下载。。。。");
                    }

                    @Override
                    public void progress(long progressSize) {
                        Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
                    }

                    @Override
                    public void finish() {
                        Console.log("下载完成！");
                    }
                });

    }

    @Test
    public void excelTest() {
        ExcelReader excelReader = ExcelUtil.getReader("C:\\Users\\Think\\Desktop\\ExcelTest.xlsx");
        List<List<Object>> read = excelReader.read();
        Console.log(read);
    }

    @Test
    public void spElExpressionTest() {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression helloWorld = spelExpressionParser.parseExpression("'Hello world'");
        String helloWorldValue = helloWorld.getValue(String.class);
        Console.log(helloWorldValue);

        Expression expression = spelExpressionParser.parseExpression("9*3");
        Integer integer = expression.getValue(Integer.class);
        Console.log(integer);
    }

}
