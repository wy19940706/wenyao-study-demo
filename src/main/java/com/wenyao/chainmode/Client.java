package com.wenyao.chainmode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;

/**
 * 责任链模式的核心其实就是用一个工厂去拿处理链的引用放到集合中，然后在该工厂中循环去遍历处理链的方法进行调用
 */
public class Client {
    public static void main(String[] args) {
        // String msg = "消息";
        // ChainFactory chainFactory = new ChainFactory().addChain(new HandlerOne()).addChain(new
        // HandlerTwo());
        // chainFactory.process(msg);
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("account_id", "14368006");
        paramMap.put("level", "REPORT_LEVEL_ADVERTISER");
        paramMap.put("date_range", "{\"start_date\":\"2020-07-05\",\"end_date\":\"2020-07-05\"}");
        paramMap.put("fields",
                "[\"hour\",\"impression\",\"click\",\"cost\",\"download\",\"conversion\",\"activation\",\"ad_name\"]");
        paramMap.put("access_token", "d02a08fad41061ed6e96b3122ca51ead");
        paramMap.put("nonce", "1222ddss4443hffodddkeid4hjfjff");
        paramMap.put("timestamp", DateUtil.currentSeconds());
        String result = HttpUtil.get("https://api.e.qq.com/v1.1/hourly_reports/get", paramMap);
        System.out.println(result);
    }

}
