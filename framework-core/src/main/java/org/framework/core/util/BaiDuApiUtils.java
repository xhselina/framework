package org.framework.core.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

/**
 * baidu api utils
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/1/22 15:56.
 */
public class BaiDuApiUtils {

    public final static  String url = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber?phone=18500237786";
    public final static String apikey = "ec29d79adf7e0f620a5709988d52659b";

    public static String phoneBelongWhere(String phone){
        String result = "";
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        // 创建httppost
//        HttpPost httppost = new HttpPost(url);
//        HttpGet httppost = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.addHeader("charset","utf-8");
        httpGet.addHeader("apikey",apikey);

        //生成一个请求对象
        //生成一个http客户端对象
        HttpClient httpClient=new DefaultHttpClient();
        //使用客户端发送请求对象
        try {
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println("executing request " + httpGet.getURI());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 读取请求内容
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"utf-8"));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while((line = br.readLine())!=null){
                    sb.append(line);
                }
                // 将资料解码
                String reqBody = sb.toString();
                System.out.println(reqBody);
                result = new String(reqBody.getBytes("ISO-8859-1"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        String result = phoneBelongWhere("18500237786");
        System.out.println(result);
    }
}
