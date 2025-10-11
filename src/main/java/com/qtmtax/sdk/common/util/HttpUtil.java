package com.qtmtax.sdk.common.util;

import com.qtmtax.sdk.common.enums.QuantumTaxErrorCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.X509Certificate;
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

    private static CloseableHttpClient createHttpClient() {
        try {
            // 创建信任所有证书的SSL上下文
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadTrustMaterial((TrustStrategy) (chain, authType) -> {
                        return true;
                    })
                    .build();

            // 创建SSL连接工厂
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
                    sslContext,
                    NoopHostnameVerifier.INSTANCE
            );

            // 构建HttpClient
            return HttpClients.custom()
                    .setSSLSocketFactory(sslSocketFactory)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("创建HttpClient失败", e);
        }
    }

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

            try (CloseableHttpResponse httpResponse = createHttpClient().execute(httpPost)) {
                if (httpResponse.getStatusLine().getStatusCode() == QuantumTaxErrorCode.SUCCESS.getCode()) {
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
}
