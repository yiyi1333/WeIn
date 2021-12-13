package cn.edu.zjut.service;

import cn.edu.zjut.Until.AESUtils;
import cn.edu.zjut.Until.GetPostUntil;
import cn.edu.zjut.po.DecodeResult;
import cn.edu.zjut.po.SessionKey;
import com.mysql.cj.Session;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

//{"session_key":"VWG8n1wBOucJoF5Qd\/uz7g==","openid":"oPo1G60ca9ymS1Vy-IACgGTOoxC0"}
//        SessionKey{session_key='VWG8n1wBOucJoF5Qd/uz7g==', openid='oPo1G60ca9ymS1Vy-IACgGTOoxC0'}
public class WechatDecryptDataService {
    public SessionKey getSessionid(String appid, String appsecret, String code){
        String wxLoginUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //接口参数
        String param = "appid=" + appid + "&secret="+ appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        //调用获取session_key接口 请求方式get
        String jsonString = GetPostUntil.sendGet(wxLoginUrl, param);
        System.out.println(jsonString);
        //因为json字符串是大括号包围，所以用JSONObject解析
        JSONObject json = new JSONObject(jsonString);
        //json解析session_key值
        SessionKey sessionKey = new SessionKey();
        sessionKey.setSession_key(json.getString("session_key"));
        sessionKey.setOpenid((json.getString("openid")));
        System.out.println(sessionKey);
        return sessionKey;
    }

    public DecodeResult decodeUserInfo(String encryptedData, String iv, String sessionKey) throws InvalidAlgorithmParameterException, UnsupportedEncodingException {
        //AESUtils微信获取手机号解密工具类
        AESUtils aes = new AESUtils();
        //调用AESUtils工具类decrypt方法解密获取json串
        byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
        //判断返回参数是否为空
        if (null != resultByte && resultByte.length > 0) {
            String jsons = new String(resultByte, "UTF-8");
            System.out.println(jsons);
            JSONObject json = new JSONObject(jsons);
            //json解析phoneNumber值
            DecodeResult encodeResult = new DecodeResult(json.getString("phoneNumber"), json.getString("purePhoneNumber"), json.getString("countryCode"));
            return encodeResult;
        }
        return null;
    }

    public DecodeResult decode(String appid, String appsecret, String code, String encryptedData, String iv){
        SessionKey sessionKey = getSessionid(appid, appsecret, code);
        DecodeResult decodeResult = null;
        try {
            decodeResult = decodeUserInfo(encryptedData, iv, sessionKey.getSession_key());
        } catch (InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodeResult;
    }
}
