package cn.edu.zjut.service;

import cn.edu.zjut.Until.HttpUtils;
import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerService {
    private ConsumerMapper consumerdao;
    public ConsumerMapper getconsumerdao() {
        return consumerdao;
    }
    public void setConsumerdao(ConsumerMapper consumerdao) {
        this.consumerdao = consumerdao;
    }

    public List<Consumer> getAllConsumer(){
        List<Consumer> consumerlist = consumerdao.getAllConsumer();
        return consumerlist;
    }

    public void addConsumer(Consumer consumer){
        consumerdao.addConsumer(consumer);
    }

    public EnterpriseConsumer loginAndRegister(String phoneNumber){
        //查询是否已经存在该手机号的用户
        Consumer user = consumerdao.searchUser(phoneNumber);
        EnterpriseConsumer enterpriseConsumer = null;
        if(user != null){
            //已经存在的用户
            System.out.println(user);
            //判断用户是否是企业用户
            if(user.getEnterpriseDepartmentNumber() != null){
                //企业用户
                //查询完整的用户信息
                enterpriseConsumer = consumerdao.searchEnterpriseConsumer(phoneNumber);
            }
            else{
                //普通用户
                enterpriseConsumer = new EnterpriseConsumer();
                enterpriseConsumer.setConsumer(user);
            }
        }
        else{
            //注册一个普通用户
            Consumer newuser = new Consumer();
            newuser.setPhoneNumber(phoneNumber);
            newuser.setName("用户");
            consumerdao.addConsumer(newuser);
            //将该用户数据返回
            enterpriseConsumer = new EnterpriseConsumer();
            enterpriseConsumer.setConsumer(consumerdao.searchUser(phoneNumber));
        }
        return enterpriseConsumer;
    }

//    更新授权数据
    public EnterpriseConsumer updateAuthorizeInfo(String nickName, String avatarUrl, String phoneName){
        consumerdao.updateWxInfo(phoneName, nickName, avatarUrl);
        EnterpriseConsumer enterpriseConsumer = consumerdao.searchEnterpriseConsumer(phoneName);
        return enterpriseConsumer;
    }

    //查询企业用户
    public EnterpriseConsumer getEnterprisePrivilege(Integer customerId){
        EnterpriseConsumer enterpriseConsumer = consumerdao.searchEnterpriseConsumerById(customerId);
        return enterpriseConsumer;
    }
    //实名认证服务
    public String Certification(String realName, String idNumber, Integer consumerId){
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
        bodys.put("idNo", idNumber);
        bodys.put("name", realName);
        String respMessage = null;
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
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            JSONObject resObject = JSONObject.parseObject(result);
            respMessage = resObject.getString("respMessage");
            System.out.println(respMessage);
            if(respMessage.equals("身份证信息匹配")){
                consumerdao.modfiyCertificationInfo(consumerId, realName, idNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }
}
