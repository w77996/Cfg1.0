package com.qx.cfg.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientGet {
	private static Logger logger = LoggerFactory.getLogger(HttpClientGet.class);
	private static final String defaultCharset = "utf-8";
	private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	private static RequestConfig requestConfig = null;
	static {
		requestConfig = RequestConfig.custom().setConnectionRequestTimeout(100).setConnectTimeout(3000)
				.setSocketTimeout(3000).build();
	}

	public static String doGet(String url) {
		HttpResponse httpResponse = null;
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");
		// 添加head方法二
		httpGet.addHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"));
		httpGet.setConfig(requestConfig);
		String reponseStr = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			reponseStr = EntityUtils.toString(httpResponse.getEntity(), defaultCharset);
		} catch (Exception e) {
			logger.error("http error.", e);
		}

		return reponseStr;
	}
	
	public static String doPost(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(180 * 1000).setConnectionRequestTimeout(180 * 1000)
                .setSocketTimeout(180 * 1000).setRedirectsEnabled(true).build();
        httpPost.setConfig(requestConfig);
        try {
            logger.info("httpPost ===**********===>>> " + EntityUtils.toString(httpPost.getEntity()));
            HttpResponse response = httpClient.execute(httpPost);
            String strResult = "";
            if (response.getStatusLine().getStatusCode() == 200) {
                 strResult = EntityUtils.toString(response.getEntity());
                 return strResult;
            } else {
                return "Error Response: " + response.getStatusLine().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "post failure :caused by-->" + e.getMessage().toString();
        }finally {
            if(null != httpClient){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
