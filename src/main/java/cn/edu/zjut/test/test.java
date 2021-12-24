package cn.edu.zjut.test;


import cn.edu.zjut.Until.GetPostUntil;
import cn.edu.zjut.Until.HttpUtils;
import cn.edu.zjut.po.SessionKey;
import cn.edu.zjut.service.WechatDecryptDataService;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
//        String encryptedData = "7GOvMUag5C6vd1rUUD0lS9TbvZN6Gmqzy+05SsTjoJO9dLfx5c+3fQPCxlyE16SjRQ9jLgDXoL/DkTx7b2QKl0ozswGOVYavaASgBx52yrWI+PixSqPJe5zJ7ZvBx5OTgxljmzvC19dHfu984HcXNvxuWV9gY5zOgrZpphBKGf779VmyF0eUJzYsI2rEgzQGwYG6UJQIDgbvmde2AWhDQw==";
//        String session_key =  "VWG8n1wBOucJoF5Qd\\/uz7g==";
//        String iv = "Crbimq1+ZgOZGElqFkfeDg==";
//        WechatDecryptDataService wechatDecryptDataService = new WechatDecryptDataService();
//        try {
//            wechatDecryptDataService.decodeUserInfo(encryptedData, iv, session_key);
//        } catch (InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//
//        System.out.println(formatter.format(date));
//        Time time = new Time(date.getTime());
//        System.out.println(time);
        String host = "https://idenauthen.market.alicloudapi.com";
        String path = "/idenAuthentication";
        String method = "POST";
        String appcode = "dec7643d04a841488d3ef0b461728bc6";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("idNo", "33108220001114659X");
        bodys.put("name", "郑展逸");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
