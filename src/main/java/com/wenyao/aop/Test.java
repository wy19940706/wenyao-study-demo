package com.wenyao.aop;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import org.joda.time.LocalDateTime;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;


public class Test {
    public static void main(String[] args) throws Exception {
        FileUtil.newFile("/test.txt");

        // Target jdkProxy = JdkDynamicAop.newProxyInstance(new TargetImpl());

        // jdkProxy.jdkTest();
        //
        // Target cglibProxy = CglibDynamicAop.newProxyInstance(TargetImpl.class);
        // cglibProxy.cgliTest();
        // long nowTime = System.currentTimeMillis();
        // LocalDateTime localDateTime = new LocalDateTime(nowTime);
        //// WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        // WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
        // int weeks = localDateTime.get(weekFields.weekOfYear());
        // System.out.println("获取当前时间第" + weeks + "周");
        // System.out.println(localDateTime.getWeekOfWeekyear());
//        String string = String.valueOf(NumberUtil.div(50, 100, 2));
//        String subPre = string.endsWith("0") ? string : StrUtil.subPre(string, string.length() - 1);
//        System.out.println(subPre);
//        File file = FileUtil.newFile("https://ydschool-video.nosdn.127.net/16106940556551.jpeg");
//        System.out.println(file);
//        DateTime parse = DateUtil.parse("2022-01-03");
//        int weekOfYear = DateUtil.weekOfYear(parse);
//        System.out.println(weekOfYear);
//        LocalDateTime localDateTime = new LocalDateTime(parse.getTime());
//        int week = localDateTime.getWeekOfWeekyear() + 1;
//        System.out.println(week);
        // QrCodeUtil.generate("https://ke.youdao.com/market-cms/pay/base.html?courseId=85668",
        // QrConfig.create().setWidth(10), FileUtil.newFile("/Users/wenyao/Downloads/test.png"));
        // String url =
        // "https://open.douyin.com/oauth/access_token?client_key=awzokof3u454cvu9&client_secret=6b0d7cf3aa73315932dc088a6d185507&code=862be253273ce5463edv1KYhqEFqkZAGnv2l&grant_type=authorization_code";
        // String redirectUrl = getRedirectUrl(url);
        // String result = HttpUtil.get("https://open.douyin.com/" + redirectUrl);
        // System.out.println(result);
        // JSONObject jsonObject = (JSONObject) JSONUtil.getByPath(JSONUtil.parse(result), "data");
        // System.out.println(jsonObject.get("open_id"));
    }

    /**
     * 获取重定向地址
     * 
     * @param path
     * @return
     * @throws Exception
     */
    private static String getRedirectUrl(String path) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        return conn.getHeaderField("Location");
    }
}
