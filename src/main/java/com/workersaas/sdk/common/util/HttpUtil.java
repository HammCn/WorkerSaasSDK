package com.workersaas.sdk.common.util;

import com.workersaas.sdk.common.enums.WorkerSaasErrorCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * <h1>HttpUtil</h1>
 *
 * @author Hamm.cn
 */
public class HttpUtil {
    /**
     * Json请求头
     */
    public static final String APPLICATION_JSON = "application/json";

    /**
     * HTTP客户端
     */
    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();

    /**
     * 发起Post请求
     *
     * @param url  URL
     * @param json Json
     * @return Response
     */
    public static String post(String url, String json) {
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json);
            entity.setContentType(APPLICATION_JSON);
            httpPost.setEntity(entity);
            try (CloseableHttpResponse httpResponse = HTTP_CLIENT.execute(httpPost)) {
                if (httpResponse.getStatusLine().getStatusCode() == WorkerSaasErrorCode.SUCCESS.getCode()) {
                    HttpEntity response = httpResponse.getEntity();
                    if (Objects.nonNull(response)) {
                        return EntityUtils.toString(response);
                    }
                    throw new RuntimeException("服务器未返回数据，请联系技术支持");
                }
                throw new RuntimeException("服务器返回异常，请联系技术支持");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        HTTP_CLIENT.close();
    }
}
