package com.rambo.tools;

import com.google.common.base.Joiner;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * HTTP工具类，提供发送get/post请求等操作
 * 
 * @author baizhanshi 2018年6月25日 下午1:52:38
 */
public class HttpUtils {

    private HttpUtils() {
    }

    public static final String                  AUTHORIZATION                 = "Authorization";
    public static final String                  DEFAULT_ENCODE                = "UTF-8";
    public static final String                  APPLICATION_JSON              = "application/json";
    public static final ContentType             CONTENT_TYPE_APPLICATION_JSON = ContentType.create(APPLICATION_JSON,
            Charset.forName(getEncode(DEFAULT_ENCODE)));

    public static final HttpClient              DEFAULT_HTTP_CLIENT           = new LoggableHttpClient();

    public static final ResponseHandler<String> STRING_RESPONSE_HANDLER;

    private static final String                 UNKNOWN_IP                    = "unknown";

    static {

        STRING_RESPONSE_HANDLER = new ResponseHandler<String>() {

            @Override
            public String handleResponse(final HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }

        };
    }

    /**
     * 获取ip
     * 
     * @param request
     * @return
     */
    public static String getActualIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-TestClient-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-TestClient-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * Map转换为Url路径字符串
     * 
     * @param map
     * @param isURLEncoder
     * @param encode
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String mapToFormString(Map<?, ?> map, boolean isURLEncoder, String encode)
            throws UnsupportedEncodingException {
        String formString = null;
        if (map != null && map.size() > 0) {
            formString = Joiner.on("&").withKeyValueSeparator("=").join(map);
            if (isURLEncoder) {
                formString = URLEncoder.encode(formString, getEncode(encode));
            }
        }
        return formString;
    }

    /**
     * @param encode
     * @return
     */
    private static String getEncode(String encode) {
        return StringUtils.isEmpty(encode) ? DEFAULT_ENCODE : encode;
    }
    /**
     * 发送拼接字符串格式的GET请求
     * 
     * @param url
     * @param params
     * @param isURLEncoder
     * @param encode
     * @return
     * @throws IOException
     */
    public static String sendGet(@NonNull String url, String params, boolean isURLEncoder, String encode,
                                 Map<String, String> headerMap)
            throws IOException {
        params = StringUtils.isEmpty(params) ? StringUtils.EMPTY : params;
        if (params != null && isURLEncoder) {
            params = URLEncoder.encode(params, getEncode(encode));
        }
        HttpGet httpGet = new HttpGet(url + "?" + params);
        if (headerMap != null) {
            headerMap.forEach((k, v) -> httpGet.setHeader(k, v));
        }
        return DEFAULT_HTTP_CLIENT.execute(httpGet, STRING_RESPONSE_HANDLER);
    }

    public static String sendGet(@NonNull String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        return DEFAULT_HTTP_CLIENT.execute(httpGet, STRING_RESPONSE_HANDLER);
    }

    /**
     * 发送Map参数的GET请求
     * 
     * @param url
     * @param params
     * @param isURLEncoder
     * @param encode
     * @return
     * @throws IOException
     */
    public static String sendGet(@NonNull String url, Map<String, Object> params, boolean isURLEncoder, String encode,
                                 Map<String, String> headerMap)
            throws IOException {
        String formString = mapToFormString(params, isURLEncoder, encode);
        return sendGet(url, formString, isURLEncoder, encode, headerMap);
    }

    public static String sendGet(@NonNull String url, Map<String, Object> params, boolean isURLEncoder, String encode)
            throws IOException {
        return sendGet(url, params, isURLEncoder, encode, null);
    }

    /**
     * 发送json参数格式的post请求，contentType默认为application/json
     * 
     * @param url
     * @param params
     * @param encode
     * @return
     * @throws IOException
     */
    public static String sendPostByJson(@NonNull String url, String params, String encode,
                                        Map<String, String> headerMap)
            throws IOException {
        HttpPost httpPost = new HttpPost(url);
        ContentType type = ContentType.create(APPLICATION_JSON, Charset.forName(getEncode(encode)));
        StringEntity jsonEntity = new StringEntity(params, type);
        httpPost.setEntity(jsonEntity);
        if (headerMap != null) {
            headerMap.forEach((k, v) -> httpPost.setHeader(k, v));
        }
        return DEFAULT_HTTP_CLIENT.execute(httpPost, STRING_RESPONSE_HANDLER);
    }

    public static String sendPostByJson(@NonNull String url, String params, String encode) throws IOException {
        return sendPostByJson(url, params, encode, null);
    }

    /**
     * 发送json参数格式的post请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String sendPostData(String url, String params, String authorization, Map<String, String> headerMap)
            throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(AUTHORIZATION, authorization);
        httpPost.setHeader("Accept", APPLICATION_JSON);
        httpPost.setEntity(new StringEntity(params, CONTENT_TYPE_APPLICATION_JSON));
        if (headerMap != null) {
            headerMap.forEach((k, v) -> httpPost.setHeader(k, v));
        }
        return DEFAULT_HTTP_CLIENT.execute(httpPost, STRING_RESPONSE_HANDLER);
    }

    public static String sendPost(@NonNull String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        return DEFAULT_HTTP_CLIENT.execute(httpPost, STRING_RESPONSE_HANDLER);
    }

}
