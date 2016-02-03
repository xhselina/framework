package org.framework.core.util;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.framework.core.util.BelongTo.ResultDto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * baidu api utils
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/1/22 15:56.
 */
public class BaiDuApiUtils {

    public final static  String url = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber?";
    public final static String apikey = "ec29d79adf7e0f620a5709988d52659b";

    /**
     * 根据手机号，查询归属地  返回 json
     * @param phone
     * @return
     */
    public static String phoneBelongWhere(String phone){
        String result = "";
        String urlParam = "phone=" + phone;
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url + urlParam);
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
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while((line = br.readLine())!=null){
                    sb.append(line);
                }
                // 将资料解码
                String reqBody = sb.toString();
                result = EncodedUtils.unicode2String(reqBody);
                System.out.println(result);
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

    public static void main(String[] args) throws  Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = null;
//
//        Map<String,Integer> map = new HashMap<>();
//        String noFinish = "";
//        ResultDto acc = null;
//
//        File file = new File("F:\\JGS\\secret\\IdeaWorkSpace\\framework\\framework-core\\src\\main\\java\\org\\framework\\core\\util\\zw.txt");
//        try {
//
//            BufferedReader bf = new BufferedReader(new FileReader(file));
//            String content = "";
//            StringBuilder sb = new StringBuilder();
//            while(content != null){
//                content = bf.readLine();
//                if(content == null){
//                    break;
//                }
//                sb.append(content.trim());
//            }
//            bf.close();
//
//            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
//            int total =   sb.toString().split(",").length;
//            System.out.println("总共有" + total  + "个手机号需要查询归属地");
//            for (String phone:sb.toString().split(",")){
//                String result = phoneBelongWhere(phone);
//                acc = objectMapper.readValue(result, ResultDto.class);
//                if (null != acc && acc.getRetMsg().equals("success")){
//                    String province = acc.getRetData().getProvince();
//                    if (map.containsKey(province)){
//                        Integer value = map.get(province) ;
//                        map.put(province,++value);
//                    }   else{
//                        map.put(province,1);
//                    }
//
//                }  else{
//                    noFinish += phone;
//                    noFinish += ",";
//                }
//                System.out.println("还有" + --total + "需要查询归属地");
//            }
//            if (org.apache.commons.lang.StringUtils.isNotEmpty(noFinish))
//                System.out.println("转换失败记录:" + noFinish);
//            List<PhoneBean> list = new ArrayList<>();
//            for (String name:map.keySet()){
//                PhoneBean phoneBean = new PhoneBean();
//                phoneBean.name = name;
//                phoneBean.value = map.get(name);
//                list.add(phoneBean);
//            }
//
//            String result = objectMapper.writeValueAsString(list);
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                jsonGenerator.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
        String addrs = "北京,15634:上海,7373:广东,5113:浙江,4393:江苏,3896:山东,3594:陕西,3407:天津,2854:湖北,2845:四川,2537:云南,2009:河北,1983:重庆,1949:黑龙江,1803:山西,1688:辽宁,1654:湖南,1612:安徽,1564:河南,1547:福建,1545:吉林,1377:江西,1288:新疆,919:甘肃,810:广西,700:贵州,634:内蒙古,620:海南,416:宁夏,211:青海,95:西藏,1";
        List<Map<String,Object>> list = new ArrayList<>();
        for(String str : addrs.split(":")){
            Map<String,Object> map = new HashMap<>();
            map.put("name",str.split(",")[0]);
            map.put("value",Integer.valueOf(str.split(",")[1]));
            list.add(map);
        }
        String result = objectMapper.writeValueAsString(list);
            System.out.println(result);
    }
}

class PhoneBean{
    public String name;
    public Integer value;
}
