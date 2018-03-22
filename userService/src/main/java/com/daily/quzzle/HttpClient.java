package com.daily.quzzle;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 请求工具类
 *
 * @author wangjiangtao
 * @date 2018/01/31
 **/
public class HttpClient {

    /** 连接请求超时时间 单位:毫秒 default 3秒 */
    private static int connectionRequestTimeout = 3000;
    /** 连接超时时间 单位:毫秒 default 30秒 */
    private static int connectTimeout = 30000;

    public static final String ENCODE = "UTF-8";


    private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    public static String sendGetRequest(String reqURL, Map<String, String> parameters, String decodeCharset) {
        logger.info("get请求：start---------------------");
        long responseLength = 0; // 响应长度
        String responseContent = null; // 响应内容
        org.apache.http.client.HttpClient httpClient = HttpClients.createDefault(); // 创建默认的httpClient实例
        // 将map参数，拼接为string
        StringBuilder sendData = new StringBuilder();
        sendData.append(reqURL);
        sendData.append("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sendData.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (sendData.length() > 0) {
            sendData.setLength(sendData.length() - 1); // 删除最后一个&符号
        }
        try {
            HttpGet httpGet = new HttpGet(sendData.toString()); // 创建org.apache.http.client.methods.HttpGet
            httpGet.addHeader("Content-Type", "application/json");
            httpGet.addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJwdXp6bGUiLCJpYXQiOjE1MTczMDc4MjksInN1YiI6IjEiLCJleHAiOjE1MTc5MTI2MjksIm5hbWUiOiJhZG1pbiJ9.bV8FtGZZGHMDJQo8XvDjeSuIqDU6NhhjHKyIDb1xR14");
            RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
                    .setConnectTimeout(connectTimeout).build();

            httpGet.setConfig(config);
            HttpResponse response = httpClient.execute(httpGet);// 执行get请求
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                if (null != entity) {
                    responseLength = entity.getContentLength();
                    responseContent = EntityUtils.toString(entity, decodeCharset == null ? "UTF-8" : decodeCharset);
                    responseContent = StringEscapeUtils.unescapeJava(responseContent);
                    EntityUtils.consume(entity);
                }
                logger.info("请求地址：{}", reqURL);
                logger.info("响应状态：{}", response.getStatusLine());
                logger.info("响应长度：{}", responseLength);
                logger.info("响应内容：{}", responseContent);
            }
        } catch (Exception e) {
            logger.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下", e);
        }
        logger.info("get请求：end---------------------");
        return responseContent;
    }
}
