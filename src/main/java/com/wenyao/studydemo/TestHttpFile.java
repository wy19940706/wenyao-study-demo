package com.wenyao.studydemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Nullable;

import cn.hutool.core.util.StrUtil;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class TestHttpFile {

    private static final String URL_QUESTON_PROCESS =
            "https://api-study-web.haixue.com/question/dataQuestionProcess/mysqlToCkByIds?questionIds=";
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/wenyao/Downloads/test.txt"));// 构造一个BufferedReader类来读取文件
        String s;
        while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行

            String url = StrUtil.appendIfMissing(URL_QUESTON_PROCESS, s);
            RequestBody requestBody = new RequestBody() {
                @Nullable
                @Override
                public MediaType contentType() {
                    return null;
                }

                @Override
                public void writeTo(BufferedSink bufferedSink) throws IOException {

                }
            };
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Call call = okHttpClient.newCall(request);

            Response response = call.execute();
            if (response.code() != 200) {
                throw new RuntimeException("error");
            }
            System.out.println("process success:" + s);
        }
    }
}
