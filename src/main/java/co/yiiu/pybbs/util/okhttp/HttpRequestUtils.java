package co.yiiu.pybbs.util.okhttp;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * http工具
 *
 * @author Fly
 */
public class HttpRequestUtils {
    private static Logger log = LoggerFactory.getLogger(HttpRequestUtils.class);
    private static final int SUCCESS_CODE = 200;

    /**
     * @param request
     * @return
     */
    public static String getJsonStrByRequest(HttpServletRequest request) {
        String param = null;
        try {
            BufferedReader streamReader = new BufferedReader(
                    new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            param = responseStrBuilder.toString();
            log.info("request:{}", param);
        } catch (Exception e) {
            log.error("流媒体服务消息回调发生异常: ", e);
        }
        return param;
    }


    /**
     * 发送GET请求
     *
     * @param url               请求url
     * @param nameValuePairList 请求参数
     * @return JSON或者字符串
     * @throws Exception
     */
    public static String sendGet(String url, List<NameValuePair> nameValuePairList) throws Exception {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();  //创建HttpClient对象
            URIBuilder uriBuilder = new URIBuilder(url);  //创建URIBuilder
            if (nameValuePairList != null && !nameValuePairList.isEmpty()) {
                uriBuilder.addParameters(nameValuePairList);//设置参数
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());        // 创建HttpGet

//            String authorization = ThreadUtils.getToken();
//            if (authorization != null) {
//                log.info("Authorization", authorization);
//                httpGet.setHeader("Authorization", authorization);
//            }
//	        httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));   //设置请求头部编码
//            httpGet.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));  //设置返回编码
            response = client.execute(httpGet);//请求服务
            int statusCode = response.getStatusLine().getStatusCode();        //获取响应吗
            if (SUCCESS_CODE == statusCode) {
                HttpEntity entity = response.getEntity();        //* 获取返回对象
                String result = EntityUtils.toString(entity, "UTF-8");  //通过EntityUitls获取返回内容
                return result;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) response.close();
            if (client != null) client.close();
        }
        return null;
    }

    public static String sendPostWithJson(String url, String json) throws Exception {
        return sendPostWithJson(url, json, null);
    }

    public static String sendPostWithJson(String url, String json, String authorization) throws Exception {
        log.info("发送post请求, url:{}, param:{}", url, json);
        String returnValue = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();
            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
//            authorization = ThreadUtils.getToken();
//            log.info("authorization :{}", authorization);
//            if (authorization != null) {
//                log.info("Authorization", authorization);
//                httpPost.setHeader("Authorization", authorization);
//            }
            httpPost.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost, responseHandler); //调接口获取返回值时，必须用此方法

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw e;
            }
        }
        //第五步：处理返回值
        return returnValue;
    }

    public static String sendPutWithJson(String url, String json) throws Exception {
        String returnValue = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();
            //第二步：创建HttpPut对象
            HttpPut httpPut = new HttpPut(url);
            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPut.setHeader("Content-type", "application/json");
//            String authorization = ThreadUtils.getToken();
//            log.info("authorization :{}", authorization);
//            if (authorization != null) {
//                log.info("Authorization", authorization);
//                httpPut.setHeader("Authorization", authorization);
//            }
            httpPut.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPut, responseHandler); //调接口获取返回值时，必须用此方法

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw e;
            }
        }
        //第五步：处理返回值
        return returnValue;
    }


    public static CloseableHttpClient createSSLClientDefault() {
        try {
            //使用 loadTrustMaterial() 方法实现一个信任策略，信任所有证书
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            //NoopHostnameVerifier类:  作为主机名验证工具，实质上关闭了主机名验证，它接受任何
            //有效的SSL会话并匹配到目标主机。
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();

    }


    public static String uploadFileByFilePath(String url, String fileName, String filePath) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000).build();
            httppost.setConfig(requestConfig);
            FileBody bin = new FileBody(new File(filePath));
            StringBody fileNameBody = new StringBody(fileName, ContentType.APPLICATION_JSON);
            StringBody userId = new StringBody("1", ContentType.APPLICATION_JSON);
            StringBody fileSource = new StringBody("1", ContentType.APPLICATION_JSON);
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("file", bin)
                    .addPart("fileName", fileNameBody)
                    .addPart("fileSource", fileSource)
                    .addPart("userId", userId).build();
            httppost.setEntity(reqEntity);
//			System.out.println("executing request " + httppost.getRequestLine()); 
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    String responseEntityStr = EntityUtils.toString(response.getEntity());
                    return responseEntityStr;
//					System.out.println("Response content length: " + resEntity.getContentLength()); 
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static String uploadFileByFilePath(String url, String fileName, File file, Long uid) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000).build();
            httppost.setConfig(requestConfig);
            FileBody bin = new FileBody(file);
            StringBody fileNameBody = new StringBody(fileName, ContentType.APPLICATION_JSON);
            log.info("uid: ", uid);
            StringBody userId = new StringBody(String.valueOf(uid), ContentType.APPLICATION_JSON);
            StringBody fileSource = new StringBody("直播", ContentType.APPLICATION_JSON);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart("file", bin)
                    .addPart("fileName", fileNameBody)
                    .addPart("fileSource", fileSource)
                    .addPart("userId", userId)
                    .setCharset(CharsetUtils.get("UTF-8")).build();
            httppost.setEntity(reqEntity);
            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    String responseEntityStr = EntityUtils.toString(response.getEntity());
                    return responseEntityStr;
//					System.out.println("Response content length: " + resEntity.getContentLength()); 
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }


//	public static void main(String[] args) {
//		String fileName = "2019.09.01-2019.09.29主播业绩";
//		String filePath = "D:\\log\\1.xlsx";
//		File test = new File(filePath);
//		System.out.println(test.exists());
//		String url = "https://multimedia.dev.qiuhui.com:1034/upload/bigFileAndPercent";
//		System.out.println(System.getProperty("user.dir"));
//		try {
////			uploadFileByFilePath(url , fileName ,filePath);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


}
